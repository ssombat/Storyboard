package com.example.neema.storyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    Button signupButton;
    EditText username, fullName, email, password, passwordConfirm;

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

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
