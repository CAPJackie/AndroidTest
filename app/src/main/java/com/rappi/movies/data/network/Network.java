package com.rappi.movies.data.network;


import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;

import java.util.List;
import java.util.Map;

public interface Network
{
    //void getMovies(RequestCallback<Map<Integer,Movie>> requestCallback);

    void getMoviesByCategory(String category, RequestCallback<List<Movie>> requestCallback);

    void getPopularMovies(RequestCallback<MovieSearch> requestCallback );

    void getTopRatedMovies(RequestCallback<List<Movie>> requestCallback);

    void getUpcomingMovies(RequestCallback<List<Movie>> requestCallback);

    void getMoviesByQuery(String query, RequestCallback<MovieSearch> requestCallback);
}