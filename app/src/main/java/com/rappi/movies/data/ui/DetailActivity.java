package com.rappi.movies.data.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;

public class DetailActivity extends AppCompatActivity {
    Movie selectedMovie;
    private Toolbar toolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_activity);
        initToolBar();
    }

    private void initToolBar() {
        toolBar = findViewById(R.id.detail_bar);
        setSupportActionBar(toolBar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        if(menu.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(menu);
    }
}
