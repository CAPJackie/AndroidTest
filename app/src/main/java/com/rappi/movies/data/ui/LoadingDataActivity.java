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

            Type type = new TypeToken<List<Program>>() {
            }.getType();
            LocalStorage.setPopularMovies((List<Program>) gson.fromJson(defaultPopularMovies, type));
            LocalStorage.setTopRatedMovies((List<Program>) gson.fromJson(defaultTopRatedMovies, type));
            LocalStorage.setUpcomingMovies((List<Program>) gson.fromJson(defaultUpcomingMovies, type));

            Log.d("Popular Movies", String.valueOf(LocalStorage.getPopularMovies()));
            Log.d("TopRated Movies", String.valueOf(LocalStorage.getTopRatedMovies()));
            Log.d("Upcoming Movies", String.valueOf(LocalStorage.getUpcomingMovies()));


            LocalStorage.setPopularTvShows((List<Program>) gson.fromJson(defaultPopularTvShows, type));
            LocalStorage.setTopRatedTvShows((List<Program>) gson.fromJson(defaultTopRatedTvShows, type));
            LocalStorage.setUpcomingTvShows((List<Program>) gson.fromJson(defaultUpcomingTvShows, type));

            Log.d("Popular TvShows", String.valueOf(LocalStorage.getPopularTvShows()));
            Log.d("TopRated TvShows", String.valueOf(LocalStorage.getTopRatedTvShows()));
            Log.d("Upcoming TvShows", String.valueOf(LocalStorage.getUpcomingTvShows()));

            Intent intent = new Intent(getApplicationContext(), MoviesActivity.class);
            startActivity(intent);


        } else {
            LocalStorage.retrofitNetwork.getPopularMovies(new RequestCallback<Search>() {
                @Override
                public void onSuccess(Search response) {
                    List<Program> movies = response.getResults();
                    LocalStorage.setPopularMovies(movies);

                    SharedPreferences.Editor prefsEditor = preferences.edit();
                    String jsonPopularMovies = gson.toJson(movies);
                    prefsEditor.putString("popularMovies", jsonPopularMovies);
                    prefsEditor.apply();

                    LocalStorage.retrofitNetwork.getTopRatedMovies(new RequestCallback<Search>() {
                        @Override
                        public void onSuccess(Search response) {
                            List<Program> movies = response.getResults();
                            LocalStorage.setTopRatedMovies(movies);

                            SharedPreferences.Editor prefsEditor = preferences.edit();
                            String jsonTopRatedMovies = gson.toJson(movies);
                            prefsEditor.putString("topRatedMovies", jsonTopRatedMovies);
                            prefsEditor.apply();

                            LocalStorage.retrofitNetwork.getUpcomingMovies(new RequestCallback<Search>() {
                                @Override
                                public void onSuccess(Search response) {
                                    List<Program> movies = response.getResults();
                                    LocalStorage.setUpcomingMovies(movies);

                                    SharedPreferences.Editor prefsEditor = preferences.edit();
                                    String jsonUpcomingMovies = gson.toJson(movies);
                                    prefsEditor.putString("upcomingMovies", jsonUpcomingMovies);
                                    prefsEditor.apply();

                                    Log.d("Popular Movies", String.valueOf(LocalStorage.getPopularMovies()));
                                    Log.d("TopRated Movies", String.valueOf(LocalStorage.getTopRatedMovies()));
                                    Log.d("Upcoming Movies", String.valueOf(LocalStorage.getUpcomingMovies()));


                                    LocalStorage.retrofitNetwork.getPopularTvShows(new RequestCallback<Search>() {
                                        @Override
                                        public void onSuccess(Search response) {
                                            List<Program> tvShows = response.getResults();
                                            LocalStorage.setPopularTvShows(tvShows);

                                            SharedPreferences.Editor prefsEditor = preferences.edit();
                                            String jsonPopularTvShows = gson.toJson(tvShows);
                                            prefsEditor.putString("popularTvShows", jsonPopularTvShows);
                                            prefsEditor.apply();

                                            LocalStorage.retrofitNetwork.getTopRatedTvShows(new RequestCallback<Search>() {
                                                @Override
                                                public void onSuccess(Search response) {
                                                    List<Program> tvShows = response.getResults();
                                                    LocalStorage.setTopRatedTvShows(tvShows);

                                                    SharedPreferences.Editor prefsEditor = preferences.edit();
                                                    String jsonTopRatedTvShows = gson.toJson(tvShows);
                                                    prefsEditor.putString("topRatedTvShows", jsonTopRatedTvShows);
                                                    prefsEditor.apply();

                                                    LocalStorage.retrofitNetwork.getUpcomingMovies(new RequestCallback<Search>() {
                                                        @Override
                                                        public void onSuccess(Search response) {
                                                            List<Program> tvShows = response.getResults();
                                                            LocalStorage.setUpcomingTvShows(tvShows);

                                                            SharedPreferences.Editor prefsEditor = preferences.edit();
                                                            String jsonUpcomingTvShows = gson.toJson(tvShows);
                                                            prefsEditor.putString("upcomingTvShows", jsonUpcomingTvShows);
                                                            prefsEditor.apply();


                                                            Log.d("Popular TvShows", String.valueOf(LocalStorage.getPopularTvShows()));
                                                            Log.d("TopRated TvShows", String.valueOf(LocalStorage.getTopRatedTvShows()));
                                                            Log.d("Upcoming TvShows", String.valueOf(LocalStorage.getUpcomingTvShows()));

                                                            /*Intent intent = new Intent(getApplicationContext(), MoviesActivity.class);
                                                            startActivity(intent);*/

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
