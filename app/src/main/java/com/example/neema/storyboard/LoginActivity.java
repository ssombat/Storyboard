package com.example.neema.storyboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginButton, forgotPasswordButton;
    EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginButton = findViewById(R.id.loginSubmit);
        forgotPasswordButton = findViewById(R.id.forgotPasswordSubmit);
        emailInput = findViewById(R.id.emailLoginInput);
        passwordInput = findViewById(R.id.passwordLoginInput);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyCredentials(emailInput.getText().toString(), passwordInput.getText().toString())) {
                    startActivity(new Intent(LoginActivity.this, HomepageActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.invalid_login_credentials),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });
    }

    boolean verifyCredentials(String email, String password) {
        //TODO: Verify credentials with firebase here
        return false;
    }
}
