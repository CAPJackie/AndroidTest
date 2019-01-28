package com.rappi.movies.data.network;

import com.rappi.movies.data.entities.MovieSearch;

public interface Network
{

    void getPopularMovies(RequestCallback<MovieSearch> requestCallback );

    void getTopRatedMovies(RequestCallback<MovieSearch> requestCallback);

    void getUpcomingMovies(RequestCallback<MovieSearch> requestCallback);

    void getMoviesByQuery(String query, RequestCallback<MovieSearch> requestCallback);
}