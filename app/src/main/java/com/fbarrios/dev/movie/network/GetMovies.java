package com.fbarrios.dev.movie.network;

import android.os.AsyncTask;
import android.util.Log;

import com.fbarrios.dev.movie.model.Movie;
import com.fbarrios.dev.movie.model.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static com.fbarrios.dev.movie.data.Constant.API_KEY;
import static com.fbarrios.dev.movie.data.Constant.POPULAR;
import static com.fbarrios.dev.movie.data.Constant.TOP_RATED;

public class GetMovies extends AsyncTask<String, Void, List<Result>> {

    @Override
    protected List<Result> doInBackground(String... strings) {

        List<Result> results = new ArrayList<>();

        MovieListener request = MovieInterceptor.get();

        switch (strings[0]) {
            case POPULAR:
                makeCall(request.getPopular(API_KEY), results);
                break;
            case TOP_RATED:
                makeCall(request.getTopRated(API_KEY), results);
                break;
        }
        return results;
    }

    private void makeCall(Call<Movie> call, List<Result> results) {
        try {
            Response<Movie> response = call.execute();
            if (200 == response.code()) {
                results.addAll(response.body().getResults());
            }
        } catch (IOException e) {
            Log.d("TAG", "IOException: " + e);
        }
    }
}
