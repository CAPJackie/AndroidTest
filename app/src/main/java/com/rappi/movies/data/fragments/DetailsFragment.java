package com.rappi.movies.data.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
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
    private TextView homePage;
    private TextView runTime;
    private TextView adult;
    private TextView productionCompanies;
    private TextView genres;


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
        releaseDate = view.findViewById(R.id.release_date_view);
        homePage = view.findViewById(R.id.homepage_view);
        runTime = view.findViewById(R.id.runtime_view);
        adult = view.findViewById(R.id.adult_view);
        productionCompanies = view.findViewById(R.id.production_companies_view);
        genres = view.findViewById(R.id.genres_view);


        originalTitle.setText(selectedMovie.getOriginal_title());
        releaseDate.setText(selectedMovie.getRelease_date());
        homePage.setText(selectedMovie.getHomepage());
        homePage.setMovementMethod(LinkMovementMethod.getInstance());
        runTime.setText(String.valueOf(selectedMovie.getRuntime()));
        adult.setText(selectedMovie.isAdult() ? "+18" : "Non age restricted");
        for (int i = 0; i < selectedMovie.getProduction_companies().size(); i++) {
            if (i == 0) {
                productionCompanies.setText(productionCompanies.getText() + selectedMovie.getProduction_companies().get(i).getName() + ", ");
            } else {
                productionCompanies.setText(productionCompanies.getText() + "," + selectedMovie.getProduction_companies().get(i).getName());
            }
        }

        for (int i = 0; i < selectedMovie.getGenres().size(); i++) {
            genres.setText(genres.getText() + "#" + selectedMovie.getGenres().get(i).getName() + " ");
        }

    }
}
