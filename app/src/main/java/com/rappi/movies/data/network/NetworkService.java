package com.rappi.movies.data.network;

import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Search;
import com.rappi.movies.data.entities.TvShow;
import com.rappi.movies.data.persistence.LocalStorage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkService {

    @GET("movie/{category}")
    Call<Search> getMovies(@Path("category") String category,
                           @Query("api_key") String apiKey,
                           @Query("page") int page,
                           @Query("language") String language);

    @GET("movie/{movieId}")
    Call<Movie> getMovieById(@Path("movieId") int movieId,
                             @Query("api_key") String apiKey);

    @GET("movie/{movieId}/videos")
    Call<Movie> getMovieVideos(@Path("movieId") int movieId,
                               @Query("api_key") String apiKey);


    @GET("search/{type}")
    Call<Search> getSearchByQuery(@Path("type") String type,
                                  @Query("query") String query,
                                  @Query("api_key") String apiKey,
                                  @Query("page") int page,
                                  @Query("language") String language);



    @GET("tv/{category}")
    Call<Search> getTvShows(@Path("category") String category,
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
    Call<Search> getUpcomingTvShows(@Query("api_key") String api_key,
                                    @Query("first_air_date.gte") String greaterThan,
                                    @Query("first_air_date.lte") String lessThan,
                                    @Query("page") int page,
                                    @Query("language") String language);


}