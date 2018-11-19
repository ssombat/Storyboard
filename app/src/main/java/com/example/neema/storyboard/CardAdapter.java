package com.example.neema.storyboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private List<Card> cards;
    public class CardViewHolder extends RecyclerView.ViewHolder {
        private TextView title,text;

        public CardViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.textView);

        }
    }
    public CardAdapter(List<Card> cards) {
        this.cards = cards;
    }
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards,parent,false);
        return new CardViewHolder(itemView);
    }
    @Override
    public int getItemCount() {
        return cards.size();
    }
    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.text.setText("test");
        //TODO SET DATA OF THE CURRENT HOLDER

    }
}
