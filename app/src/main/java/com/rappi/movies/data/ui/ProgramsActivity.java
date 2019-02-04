package com.rappi.movies.data.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.entities.Search;
import com.rappi.movies.data.entities.TvShow;
import com.rappi.movies.data.fragments.ProgramsTabFragment;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;

import java.util.ArrayList;

public class ProgramsActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private MenuItem searchItem;
    private Gson gson;
    private SharedPreferences preferences;
    private BottomNavigationView navigation;

    private ProgramsTabFragment popularPrograms;
    private ProgramsTabFragment topRatedPrograms;
    private ProgramsTabFragment upcomingPrograms;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_popular:
                    searchItem.setVisible(false);
                    setFragment(popularPrograms);
                    return true;
                case R.id.navigation_top_rated:
                    searchItem.setVisible(false);
                    setFragment(topRatedPrograms);
                    return true;
                case R.id.navigation_upcoming:
                    searchItem.setVisible(false);
                    setFragment(upcomingPrograms);
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

        popularPrograms = new ProgramsTabFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("movies", (ArrayList<Movie>) LocalStorage.getPopularMovies());
        bundle.putSerializable("tvShows", (ArrayList<TvShow>) LocalStorage.getPopularTvShows());
        popularPrograms.setArguments(bundle);


        topRatedPrograms = new ProgramsTabFragment();

        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("movies", (ArrayList<Movie>) LocalStorage.getTopRatedMovies());
        bundle2.putSerializable("tvShows", (ArrayList<TvShow>) LocalStorage.getTopRatedTvShows());
        topRatedPrograms.setArguments(bundle2);



        upcomingPrograms = new ProgramsTabFragment();

        Bundle bundle3 = new Bundle();
        bundle3.putSerializable("movies", (ArrayList<Movie>) LocalStorage.getUpcomingMovies());
        bundle3.putSerializable("tvShows", (ArrayList<TvShow>) LocalStorage.getUpcomingTvShows());
        upcomingPrograms.setArguments(bundle3);



        navigation = findViewById(R.id.navigation);
        setFragment(popularPrograms);
        navigation.setSelectedItemId(R.id.navigation_popular);
        setViewComponents();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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
