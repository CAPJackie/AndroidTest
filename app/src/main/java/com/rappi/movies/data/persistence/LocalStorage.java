package com.rappi.movies.data.persistence;


import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.network.RetrofitNetwork;

import java.util.List;

public class LocalStorage {
    public static final RetrofitNetwork retrofitNetwork = new RetrofitNetwork();
    public static final String IMGS_URL = "https://image.tmdb.org/t/p/w500";
    public static final String API_KEY = "c05f33d6a72e0bbeb34578a678d7af79";
    public static final String YOUTUBE_URL_FIRST = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/";
    public static final String YOUTUBE_URL_SECOND = "\" frameborder=\"0\" allowfullscreen></iframe>";
    private static List<Movie> popularMovies;
    private static List<Movie> topRatedMovies;
    private static List<Movie> upcomingMovies;
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

    public static Movie getSelectedMovie() {
        return LocalStorage.selectedMovie;
    }

    public static List<Movie> getTopRatedMovies() {
        return LocalStorage.topRatedMovies;
    }

    public static void setTopRatedMovies(List<Movie> topRatedMovies) {
        LocalStorage.topRatedMovies = topRatedMovies;
    }

    public static List<Movie> getUpcomingMovies() {
        return upcomingMovies;
    }

    public static void setUpcomingMovies(List<Movie> upcomingMovies) {
        LocalStorage.upcomingMovies = upcomingMovies;
    }
}
