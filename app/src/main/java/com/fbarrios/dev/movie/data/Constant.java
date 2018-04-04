package com.fbarrios.dev.movie.data;

public abstract class Constant {

    public static final String API_KEY = "34738023d27013e6d1b995443764da44"; //FIXME: Mover a Build.config
    public static final String URL_BASE = "https://api.themoviedb.org/3/movie/";
    public static final String URL_PATH = "http://image.tmdb.org/t/p/w500/";

    public static final String POPULAR = "popular";
    public static final String TOP_RATED = "top_rated";


    public static final String OVERVIEW = "overview";
    public static final String TITLE = "title";
    public static final String POSTER_PATH = "poster_path";


    /* network*/
    public static final int TIME_OUT = 60;
    public static final int READ_TIME_OUT = 60;
}
