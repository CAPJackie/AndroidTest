package com.rappi.movies.data.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.persistence.LocalStorage;

public class DetailsFragment extends Fragment {
    private TextView originalTitle;
    private TextView releaseDate;

    private Movie selectedMovie;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, null);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        selectedMovie = LocalStorage.getSelectedMovie();
        originalTitle = view.findViewById(R.id.original_title_view);
        releaseDate =  view.findViewById(R.id.release_date_view);


        originalTitle.setText(selectedMovie.getOriginal_title());
        releaseDate.setText(selectedMovie.getRelease_date());
    }
}
