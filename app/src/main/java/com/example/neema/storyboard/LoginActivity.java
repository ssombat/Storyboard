package com.example.neema.storyboard;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {

    Button loginButton, forgotPasswordButton;
    EditText emailInput, passwordInput;
    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginButton = findViewById(R.id.loginSubmit);
        forgotPasswordButton = findViewById(R.id.forgotPasswordSubmit);
        emailInput = findViewById(R.id.emailLoginInput);
        passwordInput = findViewById(R.id.passwordLoginInput);
    }
    protected void loginPressed(View v) {
        loginRequest(emailInput.getText().toString(), passwordInput.getText().toString());
    }
    protected void forgotPasswordPressed(View v) {
        startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
    }

    private void loginRequest(String email, String password){
        mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // TODO: Need to pass in the uid of the login user to the intent
                    String userUid = mFirebaseAuth.getCurrentUser().getUid();
                    startActivity(new Intent(LoginActivity.this, HomepageActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.invalid_login_credentials),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
