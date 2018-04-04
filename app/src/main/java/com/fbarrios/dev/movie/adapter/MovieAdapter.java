package com.fbarrios.dev.movie.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fbarrios.dev.movie.R;
import com.fbarrios.dev.movie.model.Result;
import com.fbarrios.dev.movie.ui.DetailedActivity;

import java.util.List;

import static com.fbarrios.dev.movie.data.Constant.OVERVIEW;
import static com.fbarrios.dev.movie.data.Constant.POSTER_PATH;
import static com.fbarrios.dev.movie.data.Constant.TITLE;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    List<Result> results;

    public MovieAdapter(List<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        final Result result = results.get(position);
        final Context context = holder.itemView.getContext();

        holder.setTitle(result.getTitle());
        holder.setOverview(result.getOverview());
        holder.setVoteAverage(String.valueOf(result.getVote_average()));
        holder.setBackDropImage(result.getPoster_path());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);

                intent.putExtra(OVERVIEW, result.getOverview());
                intent.putExtra(TITLE, result.getTitle());
                intent.putExtra(POSTER_PATH, result.getBackdrop_path());

                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context).toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
