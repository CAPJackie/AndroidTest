package main.java.com.rappi.test.moviesrappi.data.network;

import java.util.List;
import java.util.Map;

public interface Network
{
    void getMovies(RequestCallback<Map<Integer,Movie>> requestCallback);

    void getMoviesByCategory(String category, RequestCallback<List<Movie>> requestCallback);

    void getPopularMovies(RequestCallback<User> requestCallback );

    void getTopRatedMovies(RequestCallback<User> requestCallback);

    void getUpcomingMovies(RequestCallback<Void> requestCallback);
}