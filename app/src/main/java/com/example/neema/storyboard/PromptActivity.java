package com.example.neema.storyboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class PromptActivity extends AppCompatActivity {

    EditText draftText;
    Switch privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prompt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        draftText = findViewById(R.id.draftText);

        FloatingActionButton saveButton = (FloatingActionButton) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Save button pressed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
}
