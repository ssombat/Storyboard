package com.example.neema.storyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class StartupActivity extends AppCompatActivity {

    Button loginButton, signupButton;

    //update
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);

        loginButton = findViewById(R.id.loginSubmit);
        signupButton = findViewById(R.id.signupSubmit);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartupActivity.this, LoginActivity.class));
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartupActivity.this, SignupActivity.class));
            }
        });

    }
}
