package com.example.thursday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.GameViewHolder> {

    ArrayList<DayModel> mDayModel;
    public DayAdapter(ArrayList<DayModel> game) {
        mDayModel = game;
    }

    @NonNull
    @Override
    public DayAdapter.GameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_content, viewGroup, false);
        GameViewHolder gameViewHolder = new GameViewHolder(view);
        return gameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DayAdapter.GameViewHolder gameViewHolder, int i) {
        gameViewHolder.gameName.setText(mDayModel.get(i).getmName());
        gameViewHolder.gameIgn.setText(mDayModel.get(i).getmIgn());
        gameViewHolder.gameEmail.setText(mDayModel.get(i).getmEmail());
        gameViewHolder.gamePhoto.setImageResource(mDayModel.get(i).getmPhoto());
    }

    @Override
    public int getItemCount() {
        return mDayModel.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView gameName;
        TextView gameIgn;
        TextView gameEmail;
        ImageView gamePhoto;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cv);
            gameName = (TextView)itemView.findViewById(R.id.text_name);
            gameIgn = (TextView)itemView.findViewById(R.id.text_ign);
            gameEmail = (TextView)itemView.findViewById(R.id.text_email);
            gamePhoto = (ImageView)itemView.findViewById(R.id.image_photo);
        }
    }
}
