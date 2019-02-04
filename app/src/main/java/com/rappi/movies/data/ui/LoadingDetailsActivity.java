package com.rappi.movies.data.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.entities.TvShow;
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
    private Program selectedProgram;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_details_activity);

        progressBar = findViewById(R.id.loading_details_view);


        preferences = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        gson = new Gson();

        selectedProgram = LocalStorage.getSelectedProgram();

        String defaultProgram = preferences.getString("program" + selectedProgram.getId(), "");
        if (selectedProgram instanceof Movie) {
            onClickMovie(defaultProgram);
        } else if (selectedProgram instanceof TvShow) {
            onClickTvShow(defaultProgram);
        }

    }

    public void setVideosToAdapter() {
        String videos = preferences.getString("videos" + selectedProgram.getId(), "");
        if (!videos.equals("")) {
            Type type = new TypeToken<List<Video>>() {
            }.getType();
            LocalStorage.getSelectedProgram().setResults((List<Video>) gson.fromJson(videos, type));
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            startActivity(intent);
        } else {
            if (selectedProgram instanceof Movie) {
                setMovieVideos();
            } else if (selectedProgram instanceof TvShow) {
                setTvShowsVideos();
            }

        }
    }

    private void setTvShowsVideos() {
        LocalStorage.retrofitNetwork.getTvShowVideos(selectedProgram.getId(), new RequestCallback<TvShow>() {
            @Override
            public void onSuccess(TvShow response) {
                LocalStorage.getSelectedProgram().setResults(response.getResults());
                SharedPreferences.Editor prefsEditor = preferences.edit();
                String jsonVideos = gson.toJson(response.getResults());
                prefsEditor.putString("videos" + response.getId(), jsonVideos);
                prefsEditor.apply();
                Log.d("TvShowVideos", String.valueOf(response));
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    private void setMovieVideos() {
        LocalStorage.retrofitNetwork.getMovieVideos(selectedProgram.getId(), new RequestCallback<Movie>() {
            @Override
            public void onSuccess(Movie response) {
                LocalStorage.getSelectedProgram().setResults(response.getResults());
                SharedPreferences.Editor prefsEditor = preferences.edit();
                String jsonVideos = gson.toJson(response.getResults());
                prefsEditor.putString("videos" + response.getId(), jsonVideos);
                prefsEditor.apply();
                Log.d("MovieVideos", String.valueOf(response));
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }


    private void onClickTvShow(String cachedTvShow) {
        if (!cachedTvShow.equals("")) {
            LocalStorage.setSelectedProgram(gson.fromJson(cachedTvShow, TvShow.class));
            setVideosToAdapter();
        } else {
            LocalStorage.retrofitNetwork.getTvShowById(selectedProgram.getId(), new RequestCallback<TvShow>() {
                @Override
                public void onSuccess(TvShow response) {
                    LocalStorage.setSelectedProgram(response);
                    SharedPreferences.Editor prefsEditor = preferences.edit();
                    String jsonTvShow = gson.toJson(response);
                    prefsEditor.putString("program" + response.getId(), jsonTvShow);
                    prefsEditor.apply();
                    setVideosToAdapter();
                    Log.d("ListFragmentTv", jsonTvShow);

                }

                @Override
                public void onFailed(NetworkException e) {
                    e.printStackTrace();
                }
            });
        }

    }


    private void onClickMovie(String cachedMovie) {
        if (!cachedMovie.equals("")) {
            LocalStorage.setSelectedProgram(gson.fromJson(cachedMovie, Movie.class));
            setVideosToAdapter();
        } else {
            LocalStorage.retrofitNetwork.getMovieById(selectedProgram.getId(), new RequestCallback<Movie>() {
                @Override
                public void onSuccess(Movie response) {
                    LocalStorage.setSelectedProgram(response);
                    SharedPreferences.Editor prefsEditor = preferences.edit();
                    String jsonMovie = gson.toJson(response);
                    prefsEditor.putString("program" + response.getId(), jsonMovie);
                    prefsEditor.apply();
                    setVideosToAdapter();
                    Log.d("ListFragmentMovie", jsonMovie);
                }

                @Override
                public void onFailed(NetworkException e) {
                    e.printStackTrace();
                }
            });

        }
    }
}
