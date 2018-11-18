package com.example.neema.storyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.design.widget.FloatingActionButton;

public class HomepageActivity extends AppCompatActivity {

    private FlashCardsFragment flashcards;
    private ProfileFragment profile;
    private Button settingsButton, newPostButton;
    private FloatingActionButton superButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        profile = (ProfileFragment) getFragmentManager().findFragmentById(R.id.profile);
        superButton = findViewById(R.id.newPost);

        //flashcards = (FlashCardsFragment) getFragmentManager().findFragmentById(R.id.cardList);

        superButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "floating button was clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void newPostButtonPressed() {

    }
}
