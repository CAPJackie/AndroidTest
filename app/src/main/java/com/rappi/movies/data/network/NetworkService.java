package com.rappi.movies.data.network;

import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService
{
    @GET( "discover/movie")
    Call<List<Movie>> getMoviesByCategory(@Query("with_genres") String category);

    @GET( "discover/movie?sort_by=popularity.desc&api_key=c05f33d6a72e0bbeb34578a678d7af79")
    Call<MovieSearch> getPopularMovies();


    @GET( "discover/movie?sort_by=vote_average.desc")
    Call<List<Movie>> getTopRatedMovies(@Query("sort_by") String popularity);

    //TODO
    @GET( "discover/movie?sort_by=vote_average.desc")
    Call<List<Movie>> getTopUpcomingMovies(@Query("sort_by") String popularity);
}