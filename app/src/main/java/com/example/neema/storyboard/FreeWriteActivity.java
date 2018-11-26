package com.example.neema.storyboard;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class FreeWriteActivity extends AppCompatActivity {

    EditText draftText;
    TextView visibilityText;
    TextView titleText;
    Switch privacySwitch;
    boolean isPrivate;

    Toolbar toolbar;
    //For editing title
    String titlePlaceholderText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freewrite);

        draftText = findViewById(R.id.draftText);
        visibilityText = findViewById(R.id.visibilityText);
        titleText = findViewById(R.id.toolbarTitle);
        privacySwitch = findViewById(R.id.privacySwitch);
        isPrivate = privacySwitch.isChecked();
        FloatingActionButton saveButton = (FloatingActionButton) findViewById(R.id.saveButton);
        FloatingActionButton favButton = (FloatingActionButton) findViewById(R.id.favButton);
        FloatingActionButton titleButton = (FloatingActionButton) findViewById(R.id.titleButton);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        privacySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    visibilityText.setText("Private");
                }
                else {
                    visibilityText.setText("Public");
                }
                isPrivate = isChecked;
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Save button pressed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Favorite button pressed",
                        Toast.LENGTH_SHORT).show();
            }
        });

        titleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Title edit button pressed",
                        Toast.LENGTH_SHORT).show();
                AlertDialog.Builder inputDialog = new AlertDialog.Builder(FreeWriteActivity.this);
                inputDialog.setTitle("Enter New Title:");

                final EditText input = new EditText(FreeWriteActivity.this);
                input.setPadding(80,25,80,0);
                input.setBackground(null);
                input.setInputType(InputType.TYPE_CLASS_TEXT);

                inputDialog.setView(input);

                inputDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                inputDialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        titlePlaceholderText = input.getText().toString();
                        titleText.setText(titlePlaceholderText);
                    }
                });
                inputDialog.show();
            }
        });
    }
}
