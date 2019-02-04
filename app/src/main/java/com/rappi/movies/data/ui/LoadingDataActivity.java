package com.rappi.movies.data.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.entities.Search;
import com.rappi.movies.data.entities.TvShow;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LoadingDataActivity extends AppCompatActivity {

    AnimationDrawable animation;
    private SharedPreferences preferences;
    private Gson gson;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);

        ImageView loading = findViewById(R.id.loading_view);
        animation = (AnimationDrawable) loading.getDrawable();
        animation.start();

        setData();
    }

    private void setData() {
        preferences = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        gson = new Gson();


        String defaultPopularTvShows = preferences.getString("popularTvShows", "");
        String defaultTopRatedTvShows = preferences.getString("topRatedTvShows", "");
        String defaultUpcomingTvShows = preferences.getString("upcomingTvShows", "");
        String defaultPopularMovies = preferences.getString("popularMovies", "");
        String defaultTopRatedMovies = preferences.getString("topRatedMovies", "");
        String defaultUpcomingMovies = preferences.getString("upcomingMovies", "");
        if (!defaultPopularMovies.equals("") &&
                !defaultTopRatedMovies.equals("") &&
                !defaultUpcomingMovies.equals("") &&
                !defaultPopularTvShows.equals("") &&
                !defaultTopRatedTvShows.equals("") &&
                !defaultUpcomingTvShows.equals("")) {

            Type type = new TypeToken<List<Movie>>() {
            }.getType();
            LocalStorage.setPopularMovies((List<Movie>) gson.fromJson(defaultPopularMovies, type));
            LocalStorage.setTopRatedMovies((List<Movie>) gson.fromJson(defaultTopRatedMovies, type));
            LocalStorage.setUpcomingMovies((List<Movie>) gson.fromJson(defaultUpcomingMovies, type));

            Log.d("Popular Movies", String.valueOf(LocalStorage.getPopularMovies()));
            Log.d("TopRated Movies", String.valueOf(LocalStorage.getTopRatedMovies()));
            Log.d("Upcoming Movies", String.valueOf(LocalStorage.getUpcomingMovies()));


            Type type2 = new TypeToken<List<TvShow>>() {
            }.getType();

            LocalStorage.setPopularTvShows((List<TvShow>) gson.fromJson(defaultPopularTvShows, type2));
            LocalStorage.setTopRatedTvShows((List<TvShow>) gson.fromJson(defaultTopRatedTvShows, type2));
            LocalStorage.setUpcomingTvShows((List<TvShow>) gson.fromJson(defaultUpcomingTvShows, type2));

            Log.d("Popular TvShows", String.valueOf(LocalStorage.getPopularTvShows()));
            Log.d("TopRated TvShows", String.valueOf(LocalStorage.getTopRatedTvShows()));
            Log.d("Upcoming TvShows", String.valueOf(LocalStorage.getUpcomingTvShows()));

            Intent intent = new Intent(getApplicationContext(), ProgramsActivity.class);
            startActivity(intent);


        } else {
            LocalStorage.retrofitNetwork.getPopularMovies(new RequestCallback<Search>() {
                @Override
                public void onSuccess(Search response) {
                    List<Program> movies = response.getResults();
                    if(movies.get(0) instanceof Movie){
                        List<Movie> moviesConverted = new ArrayList<>();
                        for(Program m: movies){
                            moviesConverted.add((Movie) m);
                        }
                        LocalStorage.setPopularMovies(moviesConverted);
                        setMovieCacheData(moviesConverted, "popularMovies");
                    }


                    sleepMainThread(1000);
                    setTopRatedMovies();
                }

                @Override
                public void onFailed(NetworkException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void setMovieCacheData(List<Movie> movies, String cacheName) {
        SharedPreferences.Editor prefsEditor = preferences.edit();
        String jsonPrograms = gson.toJson(movies);
        prefsEditor.putString(cacheName, jsonPrograms);
        prefsEditor.apply();

    }

    private void setTvShowCacheData(List<TvShow> tvShows, String cacheName) {
        SharedPreferences.Editor prefsEditor = preferences.edit();
        String jsonPrograms = gson.toJson(tvShows);
        prefsEditor.putString(cacheName, jsonPrograms);
        prefsEditor.apply();

    }


    private void setTopRatedMovies() {
        LocalStorage.retrofitNetwork.getTopRatedMovies(new RequestCallback<Search>() {
            @Override
            public void onSuccess(Search response) {
                List<Program> movies = response.getResults();
                if(movies.get(0) instanceof Movie){
                    List<Movie> moviesConverted = new ArrayList<>();
                    for(Program m: movies){
                        moviesConverted.add((Movie) m);
                    }
                    LocalStorage.setTopRatedMovies(moviesConverted);
                    setMovieCacheData(moviesConverted, "topRatedMovies");
                }

                sleepMainThread(1000);

                setUpcomingMovies();
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    private void setUpcomingMovies() {
        LocalStorage.retrofitNetwork.getUpcomingMovies(new RequestCallback<Search>() {
            @Override
            public void onSuccess(Search response) {
                List<Program> movies = response.getResults();
                if(movies.get(0) instanceof Movie){
                    List<Movie> moviesConverted = new ArrayList<>();
                    for(Program m: movies){
                        moviesConverted.add((Movie) m);
                    }
                    LocalStorage.setUpcomingMovies(moviesConverted);
                    setMovieCacheData(moviesConverted, "upcomingMovies");
                }



                Log.d("Popular Movies", String.valueOf(LocalStorage.getPopularMovies()));
                Log.d("TopRated Movies", String.valueOf(LocalStorage.getTopRatedMovies()));
                Log.d("Upcoming Movies", String.valueOf(LocalStorage.getUpcomingMovies()));

                sleepMainThread(1000);


                setPopularTvShows();


            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    private void setPopularTvShows() {
        LocalStorage.retrofitNetwork.getPopularTvShows(new RequestCallback<Search>() {
            @Override
            public void onSuccess(Search response) {
                List<Program> tvShows = response.getResults();
                if(tvShows.get(0) instanceof TvShow){
                    List<TvShow> tvShowsConverted = new ArrayList<>();
                    for(Program m: tvShows){
                        tvShowsConverted.add((TvShow) m);
                    }
                    LocalStorage.setPopularTvShows(tvShowsConverted);
                    setTvShowCacheData(tvShowsConverted, "popularTvShows");
                }

                sleepMainThread(1000);

                setTopRatedTvShows();
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    private void setTopRatedTvShows() {
        LocalStorage.retrofitNetwork.getTopRatedTvShows(new RequestCallback<Search>() {
            @Override
            public void onSuccess(Search response) {
                List<Program> tvShows = response.getResults();
                if(tvShows.get(0) instanceof TvShow){
                    List<TvShow> tvShowsConverted = new ArrayList<>();
                    for(Program m: tvShows){
                        tvShowsConverted.add((TvShow) m);
                    }
                    LocalStorage.setTopRatedTvShows(tvShowsConverted);
                    setTvShowCacheData(tvShowsConverted, "topRatedTvShows");
                }

                sleepMainThread(1000);

                setUpcomingTvShows();
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    private void setUpcomingTvShows() {
        LocalStorage.retrofitNetwork.getUpcomingTvShows(new RequestCallback<Search>() {
            @Override
            public void onSuccess(Search response) {
                List<Program> tvShows = response.getResults();
                if(tvShows.get(0) instanceof TvShow){
                    List<TvShow> tvShowsConverted = new ArrayList<>();
                    for(Program m: tvShows){
                        tvShowsConverted.add((TvShow) m);
                    }
                    LocalStorage.setUpcomingTvShows(tvShowsConverted);
                    setTvShowCacheData(tvShowsConverted, "upcomingTvShows");
                }
                sleepMainThread(1000);


                Log.d("Popular TvShows", String.valueOf(LocalStorage.getPopularTvShows()));
                Log.d("TopRated TvShows", String.valueOf(LocalStorage.getTopRatedTvShows()));
                Log.d("Upcoming TvShows", String.valueOf(LocalStorage.getUpcomingTvShows()));

                Intent intent = new Intent(getApplicationContext(), ProgramsActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    private void sleepMainThread(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
