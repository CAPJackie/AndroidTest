package com.rappi.movies.data.network;

import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.entities.Search;
import com.rappi.movies.data.entities.TvSearch;
import com.rappi.movies.data.entities.TvShow;
import com.rappi.movies.data.persistence.LocalStorage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkService {

    @GET("movie/{category}")
    Call<MovieSearch> getMovies(@Path("category") String category,
                                @Query("api_key") String apiKey,
                                @Query("page") int page,
                                @Query("language") String language);

    @GET("movie/{movieId}")
    Call<Movie> getMovieById(@Path("movieId") int movieId,
                             @Query("api_key") String apiKey);

    @GET("movie/{movieId}/videos")
    Call<Movie> getMovieVideos(@Path("movieId") int movieId,
                               @Query("api_key") String apiKey);


    @GET("search/movie")
    Call<MovieSearch> getMovieSearchByQuery(@Query("query") String query,
                                            @Query("api_key") String apiKey,
                                            @Query("page") int page,
                                            @Query("language") String language);


    @GET("tv/{category}")
    Call<TvSearch> getTvShows(@Path("category") String category,
                              @Query("api_key") String apiKey,
                              @Query("page") int page,
                              @Query("language") String language);


    @GET("tv/{tvShowId}")
    Call<TvShow> getTvShowById(@Path("tvShowId") int tvShowId,
                               @Query("api_key") String apiKey);


    @GET("tv/{tvShowId}/videos")
    Call<TvShow> getTvShowVideos(@Path("tvShowId") int tvShowId,
                                 @Query("api_key") String apiKey);


    @GET("discover/tv")
    Call<TvSearch> getUpcomingTvShows(@Query("api_key") String api_key,
                                      @Query("first_air_date.gte") String greaterThan,
                                      @Query("first_air_date.lte") String lessThan,
                                      @Query("page") int page,
                                      @Query("language") String language);


}