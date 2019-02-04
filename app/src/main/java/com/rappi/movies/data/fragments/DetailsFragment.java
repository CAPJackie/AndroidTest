package com.rappi.movies.data.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.entities.TvShow;
import com.rappi.movies.data.persistence.LocalStorage;

import java.nio.file.Path;

public class DetailsFragment extends Fragment {
    private TextView originalTitle;
    private TextView releaseDate;

    private Program selectedProgram;
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
        selectedProgram = LocalStorage.getSelectedProgram();
        originalTitle = view.findViewById(R.id.original_title_view);
        releaseDate = view.findViewById(R.id.release_date_view);
        homePage = view.findViewById(R.id.homepage_view);
        runTime = view.findViewById(R.id.runtime_view);
        adult = view.findViewById(R.id.adult_view);
        productionCompanies = view.findViewById(R.id.production_companies_view);
        genres = view.findViewById(R.id.genres_view);

        if (selectedProgram instanceof Movie) {
            Movie selectedMovie = (Movie) selectedProgram;
            originalTitle.setText(selectedMovie.getOriginal_title());
            releaseDate.setText(selectedMovie.getRelease_date());
            adult.setText(selectedMovie.isAdult() ? "+18" : "Non age restricted");
            runTime.setText(selectedMovie.getRuntime() + " min");
        } else if (selectedProgram instanceof TvShow) {
            TvShow selectedTvShow = (TvShow) selectedProgram;
            ((LinearLayout) view.findViewById(R.id.runtime_layout)).removeAllViews();
            originalTitle.setText(selectedTvShow.getOriginal_name());
            ((TextView) view.findViewById(R.id.original_title_label_view)).setText(getString(R.string.original_name));
            ((TextView) view.findViewById(R.id.release_date_label_view)).setText(getString(R.string.first_air_date));

            ((TextView) view.findViewById(R.id.seasons_number_label_view)).setText(getString(R.string.seasons));
            ((TextView) view.findViewById(R.id.seasons_number_view)).setText(String.valueOf(selectedTvShow.getNumber_of_seasons()));

            releaseDate.setText(selectedTvShow.getFirst_air_date());
        }
        homePage.setText(selectedProgram.getHomepage());
        homePage.setMovementMethod(LinkMovementMethod.getInstance());
        for (int i = 0; i < selectedProgram.getProduction_companies().size(); i++) {
            if (i == 0) {
                productionCompanies.setText(productionCompanies.getText() + selectedProgram.getProduction_companies().get(i).getName() + ", ");
            } else {
                productionCompanies.setText(productionCompanies.getText() + "," + selectedProgram.getProduction_companies().get(i).getName());
            }
        }

        for (int i = 0; i < selectedProgram.getGenres().size(); i++) {
            genres.setText(genres.getText() + "#" + selectedProgram.getGenres().get(i).getName() + " ");
        }
    }
}
