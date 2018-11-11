package com.example.neema.storyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;

import android.widget.EditText;
import android.widget.Button;

public class StartupActivity extends AppCompatActivity {

    Button loginButton, signupButton;

    //update
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);
        //uname = findViewById(R.id.username_edittext);
        //passwd = findViewById(R.id.password_edittext);

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

    public void signup(View v) {

    }

    public void login(View v) {

    }

    public void signupAction(View v){
        //Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        //TODO SignupActivity.java needs to be implemented
        //startActivity(intent);

    }
    public void loginAction(View v){
        //TODO database communication
    }
}
