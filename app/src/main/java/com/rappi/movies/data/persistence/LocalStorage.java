package com.rappi.movies.data.persistence;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.network.RetrofitNetwork;

import java.util.List;

public class LocalStorage {
    public static final RetrofitNetwork retrofitNetwork = new RetrofitNetwork();
    public static final String IMGS_URL = "https://image.tmdb.org/t/p/w500";
    public static final String API_KEY = "c05f33d6a72e0bbeb34578a678d7af79";
    public static final String YOUTUBE_URL_FIRST = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/";
    public static final String YOUTUBE_URL_SECOND = "\" frameborder=\"0\" allowfullscreen></iframe>";
    public static final String TMDB_BASE_URL = "https://api.themoviedb.org/3/";
    public static final String POPULAR_CATEGORY = "popular";
    public static final String TOP_RATED_CATEGORY = "top_rated";
    public static final String UPCOMING_CATEGORY = "upcoming";
    public static final int DEFAULT_PAGE = 1;

    public static final String MOVIE = "movie";
    public static final String TV_SHOW = "tv";

    private static List<Program> popularMovies;
    private static List<Program> topRatedMovies;
    private static List<Program> upcomingMovies;
    private static Program selectedMovie;
    private static Program selectedTvShow;
    private static List<Program> popularTvShows;
    private static List<Program> topRatedTvShows;
    private static List<Program> upcomingTvShows;

    public static List<Program> getPopularMovies() {
        return popularMovies;
    }

    public static void setPopularMovies(List<Program> popularMovies) {
        LocalStorage.popularMovies = popularMovies;
    }

    public static List<Program> getTopRatedMovies() {
        return topRatedMovies;
    }

    public static void setTopRatedMovies(List<Program> topRatedMovies) {
        LocalStorage.topRatedMovies = topRatedMovies;
    }

    public static List<Program> getUpcomingMovies() {
        return upcomingMovies;
    }

    public static void setUpcomingMovies(List<Program> upcomingMovies) {
        LocalStorage.upcomingMovies = upcomingMovies;
    }

    public static Program getSelectedMovie() {
        return selectedMovie;
    }

    public static void setSelectedMovie(Program selectedMovie) {
        LocalStorage.selectedMovie = selectedMovie;
    }

    public static List<Program> getPopularTvShows() {
        return popularTvShows;
    }

    public static void setPopularTvShows(List<Program> popularTvShows) {
        LocalStorage.popularTvShows = popularTvShows;
    }

    public static List<Program> getTopRatedTvShows() {
        return topRatedTvShows;
    }

    public static void setTopRatedTvShows(List<Program> topRatedTvShows) {
        LocalStorage.topRatedTvShows = topRatedTvShows;
    }

    public static List<Program> getUpcomingTvShows() {
        return upcomingTvShows;
    }

    public static void setUpcomingTvShows(List<Program> upcomingTvShows) {
        LocalStorage.upcomingTvShows = upcomingTvShows;
    }
}
