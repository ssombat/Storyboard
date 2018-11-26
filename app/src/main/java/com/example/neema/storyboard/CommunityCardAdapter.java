package com.example.neema.storyboard;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CommunityCardAdapter extends RecyclerView.Adapter<CommunityCardAdapter.CommunityViewHolder>{
    private List<Card> communityCard;

    public class CommunityViewHolder extends RecyclerView.ViewHolder  {
        //TODO ADD fields
        private TextView text;

        public CommunityViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.textView);
            //TODO GET THE FIELD FROM BY FIND VIEW BY ID
        }
    }

    public CommunityCardAdapter(List<Card> communityCard) {
        this.communityCard = communityCard;
    }
    @Override
    public CommunityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards, parent, false);

        return new CommunityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommunityViewHolder holder, int position) {
        Card card = communityCard.get(position);
        holder.text.setText("test "+ position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"clicked on card",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return communityCard.size();
    }
}

