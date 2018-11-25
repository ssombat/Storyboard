package com.example.neema.storyboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.widget.Toolbar;

public class Settings extends AppCompatActivity{
    Button changeUsername, changePassword, changeBio;
    EditText username, oldPass, newPass, newPassConfirm, bio;
    String usernameString, bioString, oldPasswordString, newPasswordString, newPassConfirmString;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState );
        setContentView(R.layout.settings);

        changeUsername = findViewById(R.id.usernameButton);
        changePassword = findViewById(R.id.passwordButton);
        changeBio = findViewById(R.id.bioButton);
        username = findViewById(R.id.changeUsername);
        oldPass = findViewById(R.id.oldpass);
        newPass = findViewById(R.id.newPass);
        newPassConfirm = findViewById(R.id.newPassConfirm);
        bio = findViewById(R.id.bio);

    }
    boolean isInfoEntered(String input){return input.length() > 0;}

    protected void usernamePressed(){
        usernameString = username.getText().toString();
        if (isInfoEntered(usernameString)){
            //TODO change username in firebase

        }
        else {username.setError("Not a Username");}

    }

    protected void passPressed(){
        oldPasswordString = oldPass.getText().toString();
        newPasswordString = newPass.getText().toString();
        newPassConfirmString = newPassConfirm.getText().toString();
        if (isInfoEntered(oldPasswordString) && isInfoEntered(newPassConfirmString) && isInfoEntered(newPassConfirmString)) {
            if (newPasswordString.length() > 5) {
                if (newPassConfirmString.equals(newPasswordString)) {
                    if (/*TODO check is old password matches database password*/) {
                        //TODO change password in database
                    }
                    else { oldPass.setError("Incorrect password"); }
                }
                else { newPass.setError(getString(R.string.error_password_mismatch)); }
            }
            else {newPass.setError("Password needs to be more than 5 characters"); }
        }
        else{
            oldPass.setError("Must enter password");
            newPass.setError("Must enter password");
            newPassConfirm.setError("Must enter password");
        }

    }

    protected void bioPressed(){
        bioString = bio.getText().toString();
        if (isInfoEntered(bioString)){
            //TODO what do you think, genius?
        }
        else{bio.setError("Must enter Bio");}
    }
}
