package com.rappi.movies.data.persistence;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.entities.TvShow;
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

    public static final String MOVIES = "movies";
    public static final String TV_SHOWS = "tvShows";
    public static final String LIST_STRING = "list";
    public static final String POPULAR_TV_SHOWS = "popularTvShows";
    public static final String TOP_RATED_TV_SHOWS = "topRatedTvShows";
    public static final String UPCOMING_TV_SHOWS = "upcomingTvShows";
    public static final String POPULAR_MOVIES = "popularMovies";
    public static final String TOP_RATED_MOVIES = "topRatedMovies";
    public static final String UPCOMING_MOVIES = "upcomingMovies";
    public static final String PROGRAM = "program";
    public static final String VIDEOS = "videos";

    private static List<Movie> popularMovies;
    private static List<Movie> topRatedMovies;
    private static List<Movie> upcomingMovies;
    private static Program selectedProgram;
    private static List<TvShow> popularTvShows;
    private static List<TvShow> topRatedTvShows;
    private static List<TvShow> upcomingTvShows;

    public static List<Movie> getPopularMovies() {
        return popularMovies;
    }

    public static void setPopularMovies(List<Movie> popularMovies) {
        LocalStorage.popularMovies = popularMovies;
    }

    public static List<Movie> getTopRatedMovies() {
        return topRatedMovies;
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

    public static Program getSelectedProgram() {
        return selectedProgram;
    }

    public static void setSelectedProgram(Program selectedProgram) {
        LocalStorage.selectedProgram = selectedProgram;
    }

    public static List<TvShow> getPopularTvShows() {
        return popularTvShows;
    }

    public static void setPopularTvShows(List<TvShow> popularTvShows) {
        LocalStorage.popularTvShows = popularTvShows;
    }

    public static List<TvShow> getTopRatedTvShows() {
        return topRatedTvShows;
    }

    public static void setTopRatedTvShows(List<TvShow> topRatedTvShows) {
        LocalStorage.topRatedTvShows = topRatedTvShows;
    }

    public static List<TvShow> getUpcomingTvShows() {
        return upcomingTvShows;
    }

    public static void setUpcomingTvShows(List<TvShow> upcomingTvShows) {
        LocalStorage.upcomingTvShows = upcomingTvShows;
    }
}
