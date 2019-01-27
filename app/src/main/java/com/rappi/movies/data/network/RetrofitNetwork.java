package com.rappi.movies.data.network;


import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetwork implements Network {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    private NetworkService networkService;

    private ExecutorService backgroundExecutor = Executors.newFixedThreadPool(2);

    public RetrofitNetwork(){
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        networkService = retrofit.create(NetworkService.class);
    }




    @Override
    public void getMoviesByCategory(final String category, final RequestCallback<List<Movie>> requestCallback) {

    }

    @Override
    public void getPopularMovies(final RequestCallback<MovieSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<MovieSearch> call = networkService.getPopularMovies();
                try {
                    Response<MovieSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getMoviesByQuery(final String query, final RequestCallback<MovieSearch> requestCallback){
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<MovieSearch> call = networkService.getMoviesByQuery(query);
                try{
                    Response<MovieSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }


    @Override
    public void getTopRatedMovies(RequestCallback<List<Movie>> requestCallback) {

    }

    @Override
    public void getUpcomingMovies(RequestCallback<List<Movie>> requestCallback) {

    }
}
