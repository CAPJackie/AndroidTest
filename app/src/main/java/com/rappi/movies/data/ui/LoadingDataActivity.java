package com.rappi.movies.data.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;

import java.lang.reflect.Type;
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


        String defaultPopularMovies = preferences.getString("popularMovies", "");
        String defaultTopRatedMovies = preferences.getString("topRatedMovies", "");
        String defaultUpcomingMovies = preferences.getString("upcomingMovies", "");
        if (!defaultPopularMovies.equals("") && !defaultTopRatedMovies.equals("") && !defaultUpcomingMovies.equals("")) {

            Type type = new TypeToken<List<Movie>>() {
            }.getType();
            LocalStorage.setPopularMovies((List<Movie>) gson.fromJson(defaultPopularMovies, type));
            LocalStorage.setTopRatedMovies((List<Movie>) gson.fromJson(defaultTopRatedMovies, type));
            LocalStorage.setUpcomingMovies((List<Movie>) gson.fromJson(defaultUpcomingMovies, type));

            Log.d("Popular", String.valueOf(LocalStorage.getPopularMovies()));
            Log.d("TopRated", String.valueOf(LocalStorage.getTopRatedMovies()));
            Log.d("Upcoming", String.valueOf(LocalStorage.getUpcomingMovies()));



            Intent intent = new Intent(getApplicationContext(), MoviesActivity.class);
            startActivity(intent);


        } else {
            LocalStorage.retrofitNetwork.getPopularMovies(new RequestCallback<MovieSearch>() {
                @Override
                public void onSuccess(MovieSearch response) {
                    List<Movie> movies = response.getResults();
                    LocalStorage.setPopularMovies(movies);

                    SharedPreferences.Editor prefsEditor = preferences.edit();
                    String jsonPopularMovies = gson.toJson(movies);
                    prefsEditor.putString("popularMovies", jsonPopularMovies);
                    prefsEditor.apply();

                    LocalStorage.retrofitNetwork.getTopRatedMovies(new RequestCallback<MovieSearch>() {
                        @Override
                        public void onSuccess(MovieSearch response) {
                            List<Movie> movies = response.getResults();
                            LocalStorage.setTopRatedMovies(movies);

                            SharedPreferences.Editor prefsEditor = preferences.edit();
                            String jsonTopRatedMovies = gson.toJson(movies);
                            prefsEditor.putString("topRatedMovies", jsonTopRatedMovies);
                            prefsEditor.apply();

                            LocalStorage.retrofitNetwork.getUpcomingMovies(new RequestCallback<MovieSearch>() {
                                @Override
                                public void onSuccess(MovieSearch response) {
                                    List<Movie> movies = response.getResults();
                                    LocalStorage.setUpcomingMovies(movies);

                                    SharedPreferences.Editor prefsEditor = preferences.edit();
                                    String jsonUpcomingMovies = gson.toJson(movies);
                                    prefsEditor.putString("upcomingMovies", jsonUpcomingMovies);
                                    prefsEditor.apply();

                                    Log.d("Popular", String.valueOf(LocalStorage.getPopularMovies()));
                                    Log.d("TopRated", String.valueOf(LocalStorage.getTopRatedMovies()));
                                    Log.d("Upcoming", String.valueOf(LocalStorage.getUpcomingMovies()));

                                    animation.stop();

                                    Intent intent = new Intent(getApplicationContext(), MoviesActivity.class);
                                    startActivity(intent);


                                }

                                @Override
                                public void onFailed(NetworkException e) {
                                    e.printStackTrace();
                                }
                            });
                        }

                        @Override
                        public void onFailed(NetworkException e) {
                            e.printStackTrace();
                        }
                    });
                }

                @Override
                public void onFailed(NetworkException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
