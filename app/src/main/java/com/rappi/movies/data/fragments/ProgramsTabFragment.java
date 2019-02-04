package com.rappi.movies.data.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.persistence.LocalStorage;

import java.util.ArrayList;
import java.util.List;

public class ProgramsTabFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private List<Program> movies;
    private List<Program> tvShows;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_fragment, null);

        movies = getArguments()==null?new ArrayList<Program>():(ArrayList<Program>) getArguments().getSerializable(LocalStorage.MOVIES);
        tvShows = getArguments()==null?new ArrayList<Program>():(ArrayList<Program>) getArguments().getSerializable(LocalStorage.TV_SHOWS);
        tabLayout = view.findViewById(R.id.program_tabs);
        viewPager = view.findViewById(R.id.containerPrograms);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(mSectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        return view;

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment instance = new ListFragment();
            switch (position){
                case 0:
                    Bundle b1 = new Bundle();
                    b1.putSerializable(LocalStorage.LIST_STRING, (ArrayList<Program>) movies);
                    instance.setArguments(b1);
                    break;
                case 1:
                    Bundle b2 = new Bundle();
                    b2.putSerializable(LocalStorage.LIST_STRING, (ArrayList<Program>) tvShows);
                    instance.setArguments(b2);
                    break;
            }
            return instance;
        }

        @Override
        public int getCount() {
            return tabLayout.getTabCount();
        }
    }
}
