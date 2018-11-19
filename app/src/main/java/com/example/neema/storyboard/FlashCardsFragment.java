package com.example.neema.storyboard;
import android.app.Activity;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FlashCardsFragment extends Fragment {
    private CardAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCardsDataAdapter();
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO fill in the stuff for the layout for the profile fragment
        View v = inflater.inflate(R.layout.cards_list,container,false);
        setupRecyclerView(v);
        return v;
    }
    private void setCardsDataAdapter() {
        List<Card> cards = new ArrayList<>();
        /*try {
            //TODO READ FROM DATABASE AND SET UP CARDS OBJECT
        }catch (Exception e) {

        }*/
        /*public Card(CardType cardType,String uid, String title, String text, boolean isPublic) {
            this.cardType = cardType;
            this.uid = uid;
            this.title = title;
            this.text = text;
            this.isPublic = isPublic;
        }*/
        Card card = new Card(CardType.FREEWRITE,"1234","test","test",true);
        cards.add(card);
        mAdapter = new CardAdapter(cards);
    }

    private void setupRecyclerView(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mAdapter);
    }
}
