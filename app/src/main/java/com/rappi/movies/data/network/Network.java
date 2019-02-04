package com.rappi.movies.data.network;

import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.entities.TvSearch;
import com.rappi.movies.data.entities.TvShow;

public interface Network
{

    void getPopularMovies(RequestCallback<MovieSearch> requestCallback );

    void getTopRatedMovies(RequestCallback<MovieSearch> requestCallback);

    void getUpcomingMovies(RequestCallback<MovieSearch> requestCallback);

    void getMovieSearchByQuery(String query, RequestCallback<MovieSearch> requestCallback);

    void getMovieById(int id, RequestCallback<Movie> requestCallback);

    void getMovieVideos(int id, RequestCallback<Movie> requestCallback);



    void getPopularTvShows(RequestCallback<TvSearch> requestCallback );

    void getTopRatedTvShows(RequestCallback<TvSearch> requestCallback);

    void getUpcomingTvShows(RequestCallback<TvSearch> requestCallback);

    void getTvShowsByQuery(String query, RequestCallback<TvSearch> requestCallback);

    void getTvShowById(int id, RequestCallback<TvShow> requestCallback);

    void getTvShowVideos(int id, RequestCallback<TvShow> requestCallback);
}