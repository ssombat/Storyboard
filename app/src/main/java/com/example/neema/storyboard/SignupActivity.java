package com.example.neema.storyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    Button signupButton;
    EditText username, fullName, email, password, passwordConfirm;
    String usernameString, fullNameString, emailString, passwordString, passwordConfirmString;
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
            if (passwordString == passwordConfirmString) {
                User newUser = new User(usernameString, fullNameString, emailString, passwordString);
                //TODO: upload new user to firebase
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
}
