package com.rappi.movies.data.network;

import android.graphics.Movie;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService
{
    @GET( "discover/movie")
    Call<Map<Integer, Movie>> getMoviesByCategory(@Query("with_genres") String category);

    @GET( "discover/movie?sort_by=popularity.desc")
    Call<Map<Integer, Movie>> getPopularMovies(@Query("sort_by") String popularity);

    @GET( "discover/movie?sort_by=vote_average.desc")
    Call<Map<Integer, Movie>> getTopRatedMovies(@Query("sort_by") String popularity);

    //TODO
    @GET( "discover/movie?sort_by=vote_average.desc")
    Call<Map<Integer, Movie>> getTopUpcomingMovies(@Query("sort_by") String popularity);
}