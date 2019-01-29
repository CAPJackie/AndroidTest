package com.rappi.movies.data.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RecyclerAdapter;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Toolbar toolBar;
    MenuItem searchItem;
    Gson gson;
    String searchQuery;

    private SharedPreferences.Editor editor;
    SharedPreferences preferences;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_popular:
                    searchItem.setVisible(true);
                    movies = LocalStorage.getPopularMovies();
                    setListToAdapter();
                    return true;
                case R.id.navigation_top_rated:
                    searchItem.setVisible(false);
                    movies = LocalStorage.getTopRatedMovies();
                    setListToAdapter();
                    return true;
                case R.id.navigation_upcoming:
                    searchItem.setVisible(false);
                    movies = LocalStorage.getUpcomingMovies();
                    setListToAdapter();
                    return true;
                case R.id.navigation_search:
                    //setSearchListeners();
                    searchItem.setVisible(true);
                    //setQueryMovies();
                    //setListToAdapter();
                    return true;
            }
            return false;
        }
    };

    private void setQueryMovies() {
        LocalStorage.retrofitNetwork.getMoviesByQuery(searchQuery, new RequestCallback<MovieSearch>() {
            @Override
            public void onSuccess(MovieSearch response) {
                List<Movie> movies = response.getResults();
                //LocalStorage.setQueryMovies(movies);
                setListToAdapter();
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }


    private void setListToAdapter() {
        adapter = new RecyclerAdapter(movies);
        ((RecyclerAdapter) adapter).setOnClick(new RecyclerAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {
                LocalStorage.setSelectedMovie(movies.get(position));
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("DATE", (new SimpleDateFormat("yyyy-MM-dd")).format((Calendar.getInstance()).getTime()));
        setViewComponents();
        setRecyclerViewComponents();
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        preferences = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        gson = new Gson();
        setMoviesData();
    }

    private void setRecyclerViewComponents() {
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        setListToAdapter();
    }


    private void setViewComponents() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolBar = findViewById(R.id.app_bar);
        setSupportActionBar(toolBar);
    }

    private void setMoviesData() {
        handlePopularMoviesData();
        handleUpcomingMoviesData();
        handleTopRatedMoviesData();
    }

    private void handleTopRatedMoviesData() {
        String moviesJson = preferences.getString("topRatedMovies", "");
        if (!moviesJson.equals("")) {
            Type type = new TypeToken<List<Movie>>() {
            }.getType();
            System.out.println(moviesJson);
            List<Movie> topRatedMovies = gson.fromJson(moviesJson, type);
            Log.d("Top Rated", "Hay cache almacenado");
            LocalStorage.setTopRatedMovies(topRatedMovies);
        } else {
            Log.d("Top Rated", "No hay Cache");
            setTopRatedMovies();
        }
    }

    private void handleUpcomingMoviesData() {
        String moviesJson = preferences.getString("upcomingMovies", "");
        if (!moviesJson.equals("")) {
            Type type = new TypeToken<List<Movie>>() {
            }.getType();
            System.out.println(moviesJson);
            List<Movie> upcomingMovies = gson.fromJson(moviesJson, type);
            Log.d("Upcoming", "Hay cache almacenado");
            LocalStorage.setUpcomingMovies(upcomingMovies);
        } else {
            Log.d("Upcoming", "No hay Cache");
            setUpcomingMovies();
        }
    }

    private void handlePopularMoviesData() {
        String moviesJson = preferences.getString("popularMovies", "");
        if (!moviesJson.equals("")) {
            Type type = new TypeToken<List<Movie>>() {
            }.getType();
            System.out.println(moviesJson);
            List<Movie> popularMovies = gson.fromJson(moviesJson, type);
            Log.d("Popular", "Hay cache almacenado");
            LocalStorage.setPopularMovies(popularMovies);
        } else {
            Log.d("Popular", "No hay Cache");
            setPopularMovies();
        }
    }

    private void setUpcomingMovies() {

        LocalStorage.retrofitNetwork.getUpcomingMovies(new RequestCallback<MovieSearch>() {
            @Override
            public void onSuccess(MovieSearch response) {
                List<Movie> movies = response.getResults();
                LocalStorage.setUpcomingMovies(movies);

                SharedPreferences.Editor prefsEditor = preferences.edit();
                String jsonUpcomingMovies = gson.toJson(movies);
                System.out.println(jsonUpcomingMovies);
                prefsEditor.putString("upcomingMovies", jsonUpcomingMovies);
                prefsEditor.apply();
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    private void setTopRatedMovies() {
        LocalStorage.retrofitNetwork.getTopRatedMovies(new RequestCallback<MovieSearch>() {
            @Override
            public void onSuccess(MovieSearch response) {
                List<Movie> movies = response.getResults();
                LocalStorage.setTopRatedMovies(movies);

                SharedPreferences.Editor prefsEditor = preferences.edit();
                String jsonTopRatedMovies = gson.toJson(movies);
                System.out.println(jsonTopRatedMovies);
                prefsEditor.putString("topRatedMovies", jsonTopRatedMovies);
                prefsEditor.apply();
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    private void setPopularMovies() {
        LocalStorage.retrofitNetwork.getPopularMovies(new RequestCallback<MovieSearch>() {
            @Override
            public void onSuccess(MovieSearch response) {
                List<Movie> movies = response.getResults();
                LocalStorage.setPopularMovies(movies);

                SharedPreferences.Editor prefsEditor = preferences.edit();
                String jsonPopularMovies = gson.toJson(movies);
                System.out.println(jsonPopularMovies);
                prefsEditor.putString("popularMovies", jsonPopularMovies);
                prefsEditor.apply();

            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        searchItem = menu.findItem(R.id.search_movies);
        //setSearchListeners();

        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchItem.setVisible(false);

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.toolbar_tittle).setVisibility(View.INVISIBLE);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                findViewById(R.id.toolbar_tittle).setVisibility(View.VISIBLE);
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
                final Handler handler = new Handler();
                LocalStorage.retrofitNetwork.getMoviesByQuery(query, new RequestCallback<MovieSearch>() {
                    @Override
                    public void onSuccess(MovieSearch response) {
                        movies = response.getResults();
                        //LocalStorage.setQueryMovies(movies);
                        setListToAdapter();
                    }

                    @Override
                    public void onFailed(NetworkException e) {
                        e.printStackTrace();
                    }
                });
                // After 3 seconds


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void setSearchListeners() {

    }
}
