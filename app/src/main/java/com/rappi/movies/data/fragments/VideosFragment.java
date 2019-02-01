package com.rappi.movies.data.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Video;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.network.VideoAdapter;
import com.rappi.movies.data.persistence.LocalStorage;

import java.util.ArrayList;
import java.util.List;

public class VideosFragment extends Fragment {

    RecyclerView recyclerView;

    Movie selectedMovie;
    VideoAdapter adapter;
    List<Video> videos = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videos_fragment, null);
        selectedMovie = LocalStorage.getSelectedMovie();
        Log.d("NO INTERESA", String.valueOf(selectedMovie));
        videos = selectedMovie.getResults();
        setRecyclerViewComponents(view);
        return view;
    }

    private void setRecyclerViewComponents(View view) {
        recyclerView = view.findViewById(R.id.videos_recycler_view);
        layoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        setListToAdapter(view);
    }

    private void setListToAdapter(View view) {
        adapter = new VideoAdapter(videos);
        recyclerView.setAdapter(adapter);
        /*LocalStorage.retrofitNetwork.getMovieVideos(selectedMovie.getId(), new RequestCallback<Movie>() {
            @Override
            public void onSuccess(Movie response) {
                List<Video> movieVideos = response.getResults();
                videos = movieVideos;
                LocalStorage.getSelectedMovie().setResults(movieVideos);

                Log.d("VIDEOSFRAGMENT", String.valueOf(response));

                adapter = new VideoAdapter(videos);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });*/
    }
}
