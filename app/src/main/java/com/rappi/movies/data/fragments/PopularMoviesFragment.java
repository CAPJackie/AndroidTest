package com.rappi.movies.data.fragments;

import android.content.Intent;
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
import com.rappi.movies.data.network.RecyclerAdapter;
import com.rappi.movies.data.persistence.LocalStorage;
import com.rappi.movies.data.ui.LoadingDetailsActivity;

import java.io.Serializable;
import java.util.List;

public class PopularMoviesFragment extends Fragment {
    private List<Movie> movies;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public PopularMoviesFragment(){ ;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_fragment, null);
        layoutManager = new GridLayoutManager(view.getContext(), 3);
        //movies = LocalStorage.getPopularMovies();
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        //adapter = new RecyclerAdapter(movies);
        ((RecyclerAdapter) adapter).setOnClick(onItemClickListener(view));
        recyclerView.setAdapter(adapter);
        return view;

    }

    private RecyclerAdapter.OnItemClicked onItemClickListener(final View view) {
        return new RecyclerAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {
                LocalStorage.setSelectedMovie(movies.get(position));
                Intent intent = new Intent(view.getContext(), LoadingDetailsActivity.class);
                startActivity(intent);
            }
        };

    }

}
