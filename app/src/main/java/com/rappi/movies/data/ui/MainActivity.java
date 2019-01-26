package com.rappi.movies.data.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.MovieSearch;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RecyclerAdapter;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Toolbar toolBar;


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_popular:
                    movies = LocalStorage.getPopularMovies();
                    setListToAdapter();
                    return true;
                case R.id.navigation_top_rated:
                    return true;
                case R.id.navigation_upcoming:
                    return true;
            }
            return false;
        }
    };

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
        setViewComponents();
        setRecyclerViewComponents();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setMoviesData();
    }

    private void setRecyclerViewComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        setListToAdapter();
    }


    private void setViewComponents() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    private void setMoviesData() {
        setPopularMovies();

    }

    private void setPopularMovies() {
        LocalStorage.retrofitNetwork.getPopularMovies(new RequestCallback<MovieSearch>() {
            @Override
            public void onSuccess(MovieSearch response) {
                List<Movie> movies = response.getResults();
                LocalStorage.setPopularMovies(movies);
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

}
