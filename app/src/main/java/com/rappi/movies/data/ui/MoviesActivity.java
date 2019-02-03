package com.rappi.movies.data.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Search;
import com.rappi.movies.data.fragments.PopularMoviesFragment;
import com.rappi.movies.data.fragments.TopRatedMoviesFragment;
import com.rappi.movies.data.fragments.UpcomingMoviesFragment;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RecyclerAdapter;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;

import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private List<Movie> movies;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private Toolbar toolBar;
    private MenuItem searchItem;
    private Gson gson;
    private String searchQuery;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private FrameLayout mMainFrame;

    private PopularMoviesFragment popularMoviesFragment;
    private TopRatedMoviesFragment topRatedMoviesFragment;
    private UpcomingMoviesFragment upcomingMoviesFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_popular:
                    searchItem.setVisible(false);
                    setFragment(popularMoviesFragment);
                    return true;
                case R.id.navigation_top_rated:
                    searchItem.setVisible(false);
                    setFragment(topRatedMoviesFragment);
                    return true;
                case R.id.navigation_upcoming:
                    searchItem.setVisible(false);
                    setFragment(upcomingMoviesFragment);
                    return true;
                case R.id.navigation_search:
                    searchItem.setVisible(true);
                    return true;
            }
            return false;
        }
    };

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        gson = new Gson();

        Fragment popularMovies = new PopularMoviesFragment();


        popularMoviesFragment = new PopularMoviesFragment();
        topRatedMoviesFragment = new TopRatedMoviesFragment();
        upcomingMoviesFragment = new UpcomingMoviesFragment();

        navigation = findViewById(R.id.navigation);
        mMainFrame = findViewById(R.id.main_frame);
        setFragment(popularMoviesFragment);
        setViewComponents();
        mTextMessage = findViewById(R.id.message);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void setQueryMovies() {
        LocalStorage.retrofitNetwork.getMoviesByQuery(searchQuery, new RequestCallback<Search>() {
            @Override
            public void onSuccess(Search response) {
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
        ((RecyclerAdapter) adapter).setOnClick(onItemClickListener());
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    private RecyclerAdapter.OnItemClicked onItemClickListener() {
        return new RecyclerAdapter.OnItemClicked() {
            @Override
            public void onItemClick(final int position) {
                String defaultMovie = preferences.getString("movie" + movies.get(position).getId(), "");
                if(!defaultMovie.equals("")){
                    LocalStorage.setSelectedMovie(gson.fromJson(defaultMovie, Movie.class));
                    setVideosToAdapter();
                } else{
                    LocalStorage.retrofitNetwork.getMovieById(movies.get(position).getId(), new RequestCallback<Movie>() {
                        @Override
                        public void onSuccess(Movie response) {
                            LocalStorage.setSelectedMovie(response);
                            SharedPreferences.Editor prefsEditor = preferences.edit();
                            String jsonMovie = gson.toJson(response);
                            prefsEditor.putString("movie" + response.getId(), jsonMovie);
                            prefsEditor.apply();
                            setVideosToAdapter();
                        }

                        @Override
                        public void onFailed(NetworkException e) {

                        }
                    });

                }

            }
        };
    }

    private void setVideosToAdapter() {



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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        searchItem = menu.findItem(R.id.search_movies);
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
                LocalStorage.retrofitNetwork.getMoviesByQuery(query, new RequestCallback<Search>() {
                    @Override
                    public void onSuccess(Search response) {
                        movies = response.getResults();
                        setListToAdapter();
                    }

                    @Override
                    public void onFailed(NetworkException e) {
                        e.printStackTrace();
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
