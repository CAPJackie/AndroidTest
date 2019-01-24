package com.rappi.movies.data.persistence;

import android.graphics.drawable.Drawable;

import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.network.RetrofitNetwork;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class LocalStorage {
    public static final RetrofitNetwork retrofitNetwork = new RetrofitNetwork();
    private static List<Movie> popularMovies;
    private static Movie selectedMovie;

    public static void setPopularMovies(List<Movie> popularMovies) {
        LocalStorage.popularMovies = popularMovies;
    }

    public static List<Movie> getPopularMovies() {
        return LocalStorage.popularMovies;
    }

    public static void setSelectedMovie(Movie selectedMovie) {
        LocalStorage.selectedMovie = selectedMovie;
    }

    public static Movie getSelectedMovie(){
        return LocalStorage.selectedMovie;
    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}
