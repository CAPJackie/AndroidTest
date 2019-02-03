package com.rappi.movies.data.network;

import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Search;
import com.rappi.movies.data.entities.TvShow;

public interface Network
{

    void getPopularMovies(RequestCallback<Search> requestCallback );

    void getTopRatedMovies(RequestCallback<Search> requestCallback);

    void getUpcomingMovies(RequestCallback<Search> requestCallback);

    void getMoviesByQuery(String query, RequestCallback<Search> requestCallback);

    void getMovieById(int id, RequestCallback<Movie> requestCallback);

    void getMovieVideos(int id, RequestCallback<Movie> requestCallback);



    void getPopularTvShows(RequestCallback<Search> requestCallback );

    void getTopRatedTvShows(RequestCallback<Search> requestCallback);

    void getUpcomingTvShows(RequestCallback<Search> requestCallback);

    void getTvShowsByQuery(String query, RequestCallback<Search> requestCallback);

    void getTvShowById(int id, RequestCallback<TvShow> requestCallback);

    void getTvShowVideos(int id, RequestCallback<TvShow> requestCallback);
}