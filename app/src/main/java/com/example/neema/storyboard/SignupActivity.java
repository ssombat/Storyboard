package com.example.neema.storyboard;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    Button signupButton;
    EditText username, fullName, email, password, passwordConfirm;
    String usernameString, fullNameString, emailString, passwordString, passwordConfirmString;

    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mRefUserTable = mFirebaseDatabase.getReference("UserTable");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        signupButton = findViewById(R.id.signupSubmit);
        username = findViewById(R.id.usernameInput);
        fullName = findViewById(R.id.fullNameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        passwordConfirm = findViewById(R.id.confirmPasswordInput);
    }

    boolean isInfoEntered(String unIn, String fnIn, String eIn, String pwIn, String pwcIn) {
       return (unIn.length() > 0) && (fnIn.length() > 0) && (eIn.length() > 0) && (pwIn.length() > 0) && (pwIn.length() > 0);
    }
    void signupPressed(View v) {
        usernameString = username.getText().toString();
        fullNameString = fullName.getText().toString();
        emailString = email.getText().toString();
        passwordString = password.getText().toString();
        passwordConfirmString = passwordConfirm.getText().toString();

        if (isInfoEntered(usernameString, fullNameString, emailString, passwordString, passwordConfirmString)) {
            if (passwordString.equals(passwordConfirmString)) {
                //TODO: upload new user to firebase
                registerRequest(usernameString, fullNameString, emailString, passwordString);
            }
            else {
                Toast.makeText(getApplicationContext(),
                        getString(R.string.error_password_mismatch),
                        Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.error_missing_field),
                    Toast.LENGTH_LONG).show();
        }
    }

    private void registerRequest(final String usernameString, final String fullNameString, final String emailString, String passwordString) {
        mFirebaseAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // The user has a unique id that we will use as a primary key
                    String userId = mFirebaseAuth.getCurrentUser().getUid();
                    User newUser = new User(usernameString, fullNameString, emailString, userId);
                    mRefUserTable.child(userId).setValue(newUser);
                    mFirebaseAuth.getCurrentUser().sendEmailVerification();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Registration Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
