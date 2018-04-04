package com.fbarrios.dev.movie.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fbarrios.dev.movie.R;
import com.squareup.picasso.Picasso;

import static com.fbarrios.dev.movie.data.Constant.URL_PATH;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    private ImageView backDropImageView;
    private TextView titleTextView;
    private TextView overviewTextView;
    private TextView voteAverageTextView;

    public MovieViewHolder(View view) {
        super(view);
        cardView = (CardView) view;
        backDropImageView = view.findViewById(R.id.backDropImageView);
        titleTextView = view.findViewById(R.id.titleTextView);
        overviewTextView = view.findViewById(R.id.overviewTextView);
        voteAverageTextView = view.findViewById(R.id.voteAverageTextView);
    }

    void setBackDropImage(String url) {
        Picasso.get()
                .load(URL_PATH + url)
                .resize(400,400)
                .centerInside()
                .into(backDropImageView);
    }

    void setTitle(String title) {
        titleTextView.setText(title);
    }

    void setOverview(String overview) {
        overviewTextView.setText(overview);
    }

    void setVoteAverage(String value) {
        voteAverageTextView.setText(value);
    }
}
