package com.example.neema.storyboard;
import android.app.Activity;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

public class FlashCardsFragment extends Fragment {
    private CardAdapter mAdapter;
    SwipeController swipeController;
    ItemTouchHelper itemTouchHelper;

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
            //TODO READ FROM DATABASE AND SET UP CARD OBJECT

        for(int i = 0; i < 10; i++) {
            Card card = new Card(CardType.FREEWRITE, "1234", "test", "test", true);
            cards.add(card);
        }
        mAdapter = new CardAdapter(cards);
    }
    private void setupRecyclerView(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mAdapter);
        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                //TODO REMOVE THE CARD FROM VIEW AND REMOVE FROM DATA BASE
                mAdapter.cards.remove(position);
                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position,mAdapter.getItemCount());
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
}
