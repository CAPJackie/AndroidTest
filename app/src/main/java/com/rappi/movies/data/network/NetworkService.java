package com.rappi.movies.data.network;

import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.persistence.LocalStorage;

import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkService
{

    @GET( "discover/movie?sort_by=popularity.desc&api_key=" + LocalStorage.API_KEY)
    Call<MovieSearch> getPopularMovies();


    @GET( "discover/movie?sort_by=vote_average.desc&api_key=" + LocalStorage.API_KEY)
    Call<MovieSearch> getTopRatedMovies();

    @GET( "discover/movie?api_key=" + LocalStorage.API_KEY)
    Call<MovieSearch> getUpcomingMovies(@Query("primary_release_date.gte") String firstDate, @Query("primary_release_date.gte") String secondDate);

    @GET( "search/movie?api_key=" + LocalStorage.API_KEY )
    Call<MovieSearch> getMoviesByQuery(@Query("query") String query);

    @GET( "movie/{movieId}?api_key=" + LocalStorage.API_KEY )
    Call<Movie> getMovieById(@Path("movieId") int movieId);


    @GET( "movie/{movieId}/videos?api_key=" +  LocalStorage.API_KEY)
    Call<Movie> getMovieVideos(@Path("movieId") int movieId);

}