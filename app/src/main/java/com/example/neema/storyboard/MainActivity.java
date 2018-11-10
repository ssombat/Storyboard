package com.example.neema.storyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {
    static EditText uname;
    static EditText passwd;

//update
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         uname = findViewById(R.id.username_edittext);
         passwd = findViewById(R.id.password_edittext);



    }
    public void signupAction(View v){
        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        //TODO SignupActivity.java needs to be implemented
        startActivity(intent);

    }
    public void loginAction(View v){
        //TODO database communication
    }
}
