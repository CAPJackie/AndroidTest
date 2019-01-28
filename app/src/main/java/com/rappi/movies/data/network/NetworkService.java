package com.rappi.movies.data.network;

import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.persistence.LocalStorage;

import java.security.KeyStore;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService
{

    @GET( "discover/movie?sort_by=popularity.desc&api_key=" + LocalStorage.API_KEY)
    Call<MovieSearch> getPopularMovies();


    @GET( "discover/movie?sort_by=vote_average.desc&api_key=" + LocalStorage.API_KEY)
    Call<MovieSearch> getTopRatedMovies();

    //TODO
    @GET( "discover/movie?sort_by=vote_average.desc&api_key=" + LocalStorage.API_KEY)
    Call<MovieSearch> getUpcomingMovies();

    @GET( "search/movie?api_key=" + LocalStorage.API_KEY )
    Call<MovieSearch> getMoviesByQuery(@Query("query") String query);
}