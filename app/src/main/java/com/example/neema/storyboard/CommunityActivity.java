package com.example.neema.storyboard;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommunityActivity extends AppCompatActivity {
    private CommunityCardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.community_page_layout);

        setCommunityCardAdapter();
        setupRecyclerView();
    }

    private void setCommunityCardAdapter() {
        List<Card> communityCards = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Card card = new Card(CardType.FREEWRITE, "1234", "test", "test","test", true);
            communityCards.add(card);
        }
        //TODO GET COMMUNITY CARDS

        mAdapter = new CommunityCardAdapter(communityCards);
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);
    }

}
