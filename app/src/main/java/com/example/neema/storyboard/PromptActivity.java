package com.example.neema.storyboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    EditText draftText;
    TextView visibilityText;
    Switch privacySwitch;
    boolean isPrivate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prompt);

        draftText = findViewById(R.id.draftText);
        visibilityText = findViewById(R.id.visibilityText);
        privacySwitch = findViewById(R.id.privacySwitch);
        isPrivate = privacySwitch.isChecked();
        FloatingActionButton saveButton = (FloatingActionButton) findViewById(R.id.saveButton);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        privacySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    visibilityText.setText("Visibility: Private");
                }
                else {
                    visibilityText.setText("Visibility: Public");
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


    }
}
