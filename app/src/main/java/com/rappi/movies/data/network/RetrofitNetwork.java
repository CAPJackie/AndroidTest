package com.rappi.movies.data.network;


import com.rappi.movies.data.entities.Language;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.entities.TvSearch;
import com.rappi.movies.data.entities.TvShow;
import com.rappi.movies.data.persistence.LocalStorage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetwork implements Network {
    private NetworkService networkService;
    private ExecutorService backgroundExecutor = Executors.newFixedThreadPool(5);

    public RetrofitNetwork() {
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl(LocalStorage.TMDB_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        networkService = retrofit.create(NetworkService.class);
    }

    @Override
    public void getPopularMovies(final RequestCallback<MovieSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<MovieSearch> call = networkService.getMovies(LocalStorage.POPULAR_CATEGORY, LocalStorage.API_KEY, LocalStorage.DEFAULT_PAGE, Language.ENGLISH_UNITED_STATES);
                try {
                    Response<MovieSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }


    @Override
    public void getTopRatedMovies(final RequestCallback<MovieSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<MovieSearch> call = networkService.getMovies(LocalStorage.TOP_RATED_CATEGORY, LocalStorage.API_KEY, LocalStorage.DEFAULT_PAGE, Language.ENGLISH_UNITED_STATES);
                try {
                    Response<MovieSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getUpcomingMovies(final RequestCallback<MovieSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<MovieSearch> call = networkService.getMovies(LocalStorage.UPCOMING_CATEGORY, LocalStorage.API_KEY, LocalStorage.DEFAULT_PAGE, Language.ENGLISH_UNITED_STATES);
                try {
                    Response<MovieSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getMovieSearchByQuery(final String query, final RequestCallback<MovieSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<MovieSearch> call = networkService.getMovieSearchByQuery(query, LocalStorage.API_KEY, LocalStorage.DEFAULT_PAGE, Language.ENGLISH_UNITED_STATES);
                try {
                    Response<MovieSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }




    @Override
    public void getMovieById(final int id, final RequestCallback<Movie> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<Movie> call = networkService.getMovieById(id, LocalStorage.API_KEY);
                try {
                    Response<Movie> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }


    @Override
    public void getTvShowById(final int id, final RequestCallback<TvShow> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<TvShow> call = networkService.getTvShowById(id, LocalStorage.API_KEY);
                try {
                    Response<TvShow> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getMovieVideos(final int id, final RequestCallback<Movie> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<Movie> call = networkService.getMovieVideos(id, LocalStorage.API_KEY);
                try {
                    Response<Movie> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getTvShowVideos(final int id, final RequestCallback<TvShow> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<TvShow> call = networkService.getTvShowVideos(id, LocalStorage.API_KEY);
                try {
                    Response<TvShow> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });

    }

    @Override
    public void getPopularTvShows(final RequestCallback<TvSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<TvSearch> call = networkService.getTvShows(LocalStorage.POPULAR_CATEGORY, LocalStorage.API_KEY, LocalStorage.DEFAULT_PAGE, Language.ENGLISH_UNITED_STATES);
                try {
                    Response<TvSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getTopRatedTvShows(final RequestCallback<TvSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<TvSearch> call = networkService.getTvShows(LocalStorage.TOP_RATED_CATEGORY, LocalStorage.API_KEY, LocalStorage.DEFAULT_PAGE, Language.ENGLISH_UNITED_STATES);
                try {
                    Response<TvSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getUpcomingTvShows(final RequestCallback<TvSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                String firstDate = sdf.format(c.getTime());
                c.add(Calendar.DATE, 10);
                String secondDate = sdf.format(c.getTime());
                Call<TvSearch> call = networkService.getUpcomingTvShows(LocalStorage.API_KEY, firstDate, secondDate, LocalStorage.DEFAULT_PAGE, Language.ENGLISH_UNITED_STATES);
                try {
                    Response<TvSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getTvShowsByQuery(final String query, final RequestCallback<TvSearch> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<TvSearch> call = networkService.getTvShowSearchByQuery(query, LocalStorage.API_KEY, LocalStorage.DEFAULT_PAGE, Language.ENGLISH_UNITED_STATES);
                try {
                    Response<TvSearch> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }


}
