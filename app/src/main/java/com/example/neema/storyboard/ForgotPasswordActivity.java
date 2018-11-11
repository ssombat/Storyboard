package com.example.neema.storyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button resetButton;
    EditText emailInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);

        resetButton = findViewById(R.id.submit);
        emailInput = findViewById(R.id.emailInput);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidEmail(emailInput.getText().toString())) {
                    //TODO: Add custom dialog prompting user message has been sent
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.invalid_email),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    boolean isValidEmail(String email) {
        //TODO: verify that the email provided exists in firebase, send reset email if true
        return false;
    }
}
