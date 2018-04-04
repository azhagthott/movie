package com.fbarrios.dev.movie.network;

import com.fbarrios.dev.movie.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieListener {

    @GET("popular")
    Call<Movie> getPopular(@Query("api_key") String key);

    @GET("top_rated")
    Call<Movie> getTopRated(@Query("api_key") String key);
}
