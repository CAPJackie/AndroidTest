package com.rappi.movies.data.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Video;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;

import java.lang.reflect.Type;
import java.util.List;

public class LoadingDetailsActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private SharedPreferences preferences;
    private Gson gson;
    private Movie selectedMovie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_details_activity);

        progressBar = findViewById(R.id.loading_details_view);


        preferences = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        gson = new Gson();

        //selectedMovie = LocalStorage.getSelectedMovie();

        String defaultMovie = preferences.getString("movie" + selectedMovie.getId(), "");
        if (!defaultMovie.equals("")) {
            LocalStorage.setSelectedMovie(gson.fromJson(defaultMovie, Movie.class));

            setVideosToAdapter();

        } else {
            LocalStorage.retrofitNetwork.getMovieById(selectedMovie.getId(), new RequestCallback<Movie>() {
                @Override
                public void onSuccess(Movie response) {
                    LocalStorage.setSelectedMovie(response);
                    SharedPreferences.Editor prefsEditor = preferences.edit();
                    String jsonMovie = gson.toJson(response);
                    prefsEditor.putString("movie" + response.getId(), jsonMovie);
                    prefsEditor.apply();
                    setVideosToAdapter();
                }

                @Override
                public void onFailed(NetworkException e) {
                    e.printStackTrace();
                }
            });

        }
    }

    public void setVideosToAdapter() {
        String videos = preferences.getString("videos" + LocalStorage.getSelectedMovie().getId(), "");
        if (!videos.equals("")) {
            Type type = new TypeToken<List<Video>>() {
            }.getType();
            //LocalStorage.getSelectedMovie().setResults((List<Video>) gson.fromJson(videos, type));
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            startActivity(intent);
        } else {
            LocalStorage.retrofitNetwork.getMovieVideos(LocalStorage.getSelectedMovie().getId(), new RequestCallback<Movie>() {
                @Override
                public void onSuccess(Movie response) {
                    //LocalStorage.getSelectedMovie().setResults(response.getResults());
                    SharedPreferences.Editor prefsEditor = preferences.edit();
                    //String jsonVideos = gson.toJson(LocalStorage.getSelectedMovie().getResults());
                    //prefsEditor.putString("videos" + LocalStorage.getSelectedMovie().getId(), jsonVideos);
                    prefsEditor.apply();
                    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailed(NetworkException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
