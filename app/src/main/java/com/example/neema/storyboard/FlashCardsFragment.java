package com.example.neema.storyboard;
import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.graphics.Canvas;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FlashCardsFragment extends Fragment {
    private CardAdapter mAdapter;
    SwipeController swipeController;
    ItemTouchHelper itemTouchHelper;

    private static String TAG = "Flashcard fragment";

    private FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mFirebaseDatabase.getReference("CardTable");
    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
    private String currentUser = mFirebaseAuth.getCurrentUser().getUid();
    public List<Card> cards = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRetainInstance(true);

    }
    /*@Override
    public void onViewCreated(View view, Bundle instanceSaved) {

    }*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO fill in the stuff for the layout for the profile fragment
        View v = inflater.inflate(R.layout.cards_list,container,false);
        setCardsDataAdapter(v);
        return v;
    }
    private void setCardsDataAdapter(final View v) {
        // Gets the cards out of the database for the current user
        mRef.child(currentUser).child("Cards").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cards.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Card card = createCard(postSnapshot);
                    if (!cards.contains(card))
                        cards.add(card);
                }
                mAdapter = new CardAdapter(cards);
                setupRecyclerView(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    private void setupRecyclerView(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mAdapter);
        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                Card card = mAdapter.cards.get(position);
                mAdapter.cards.remove(position);
                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position,mAdapter.getItemCount());

                //Deletes from the database
                mRef.child(currentUser).child("Cards").child(card.getCardId()).removeValue();
            }
            @Override
            public void onLeftClicked(int position) {
                //TODO BRIAN's PAGE
                Card card = mAdapter.cards.get(position);
                CardType type = card.cardType;
                Log.d(TAG, "edit was clicked");
                switch(type) {
                    case FREEWRITE:
                        //TODO FREWRITE ACTIVITY
                        Intent intent = new Intent(getActivity(), FreeWriteActivity.class);
                        intent.putExtra("Title", card.getTitle());
                        intent.putExtra("Text", card.getText());
                        intent.putExtra("uid", card.getUid());
                        intent.putExtra("Publicity", card.isPublic());
                        intent.putExtra("Cardid", card.getCardId());
                        Log.d(TAG, "Freewrite was selected");
                        startActivity(intent);
                        break;
                    case PROMPT:
                        //TODO PROMPT ACTIVITY
                        Log.d(TAG, "edit was clicked");
                        startActivity(new Intent(getActivity(),PromptActivity.class));
                        break;
                    case WEEKLY:
                        //TODO IDK IF ANYTHING IS NEEDED
                        break;

                }
            }
        });
        itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent,RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }

    private Card createCard(DataSnapshot postSnapshot) {
        String cardTypeString = (String) postSnapshot.child("cardType").getValue();
        // Need to convert the database string of card type to CardType enum
        CardType cardType = getCardType(cardTypeString);

        String uid = currentUser;
        String cardId = (String) postSnapshot.child("cardId").getValue();
        String title = (String) postSnapshot.child("title").getValue();
        String text = (String) postSnapshot.child("text").getValue();
        boolean isPublic = (boolean) postSnapshot.child("public").getValue();
        String weekly = (String) postSnapshot.child("weeklyText").getValue();

        Card card;
        switch (cardType) {
            case FREEWRITE:
                card = new Card(CardType.FREEWRITE, uid, cardId, title, text, isPublic);
                break;
            case WEEKLY:
                card = new Card(CardType.WEEKLY, uid, cardId, title, text, isPublic, weekly);
                break;
            case PROMPT:
                card = new Card(CardType.PROMPT, uid, cardId, "", text, isPublic);
            default:
                card = new Card(CardType.FREEWRITE, uid, cardId, title, text, isPublic);
        }
        return card;

    }
    private CardType getCardType(String cardType) {
        switch (cardType) {
            case "FREEWRITE":
                return CardType.FREEWRITE;
            case "PROMPT":
                return CardType.PROMPT;
            case "WEEKLY":
                return CardType.WEEKLY;
        }
        return CardType.FREEWRITE;
    }

    public void addCardToList(Card card) {
        cards.add(card);
    }
}
