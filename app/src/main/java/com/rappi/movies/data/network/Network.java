package com.rappi.movies.data.network;

import android.graphics.Movie;

import java.util.List;
import java.util.Map;

public interface Network
{
    //void getMovies(RequestCallback<Map<Integer,Movie>> requestCallback);

    void getMoviesByCategory(String category, RequestCallback<List<Movie>> requestCallback);

    void getPopularMovies(RequestCallback<Map<Integer,Movie>> requestCallback );

    void getTopRatedMovies(RequestCallback<Map<Integer,Movie>> requestCallback);

    void getUpcomingMovies(RequestCallback<Map<Integer,Movie>> requestCallback);
}