package com.fbarrios.dev.movie.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fbarrios.dev.movie.R;
import com.fbarrios.dev.movie.adapter.MovieAdapter;
import com.fbarrios.dev.movie.model.Result;
import com.fbarrios.dev.movie.network.GetMovies;

import java.util.List;

import static com.fbarrios.dev.movie.data.Constant.TOP_RATED;

public class TopRatedFragment extends Fragment {

    private RecyclerView topRatedRecyclerView;

    public TopRatedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_rated, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        topRatedRecyclerView = view.findViewById(R.id.topRatedRecyclerView);
    }

    @Override
    public void onStart() {
        super.onStart();
        new GetTopRatedMovies().execute(TOP_RATED);
    }

    private class GetTopRatedMovies extends GetMovies {

        @Override
        protected void onPostExecute(List<Result> results) {
            super.onPostExecute(results);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            topRatedRecyclerView.setLayoutManager(linearLayoutManager);
            MovieAdapter adapter = new MovieAdapter(results);
            topRatedRecyclerView.setAdapter(adapter);
        }
    }
}
