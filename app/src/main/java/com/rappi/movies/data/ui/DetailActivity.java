package com.rappi.movies.data.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.fragments.DetailsFragment;
import com.rappi.movies.data.fragments.VideosFragment;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;
import com.squareup.picasso.Picasso;

import android.support.v4.view.ViewPager;

public class DetailActivity extends AppCompatActivity {
    Movie selectedMovie;
    private Toolbar toolBar;
    private TextView movieTittle;
    private TextView movieDescription;
    private RatingBar ratingBar;
    private ImageView movieImage;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private Fragment detailsFragment;
    private Fragment videosFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_activity);
        detailsFragment = new DetailsFragment();
        videosFragment = new VideosFragment();
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.container);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mSectionsPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));





        initToolBar();
        initComponents();
    }


    private void initComponents() {
        movieTittle = findViewById(R.id.movie_tittle);
        movieDescription = findViewById(R.id.movie_description);
        ratingBar = findViewById(R.id.ratingBar);
        movieImage = findViewById(R.id.movie_image);
        selectedMovie = LocalStorage.getSelectedMovie();
        System.out.println(selectedMovie);
        Log.d("DetailActivity", String.valueOf((float)(selectedMovie.getVote_average() / 2)));
        movieTittle.setText(selectedMovie.getTitle());
        movieDescription.setText(selectedMovie.getOverview());
        ratingBar.setRating((float) (selectedMovie.getVote_average() / 2));
        ratingBar.setIsIndicator(true);
        Picasso.get().load(LocalStorage.IMGS_URL + selectedMovie.getBackdrop_path()).into(movieImage);
    }

    private void initToolBar() {
        toolBar = findViewById(R.id.detail_bar);
        setSupportActionBar(toolBar);
        toolBar.findViewById(R.id.toolbar_tittle).setVisibility(View.GONE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        if (menu.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menu);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment instance =  null;
            switch (position){
                case 0:
                    instance = detailsFragment;
                    break;
                case 1:
                    instance = videosFragment;
                    break;
            }
            return instance;
            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return tabLayout.getTabCount();
        }
    }

}
