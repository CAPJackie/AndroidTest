package com.rappi.movies.data.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.rappi.movies.R;
import com.rappi.movies.data.entities.Movie;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.entities.TvShow;
import com.rappi.movies.data.network.NetworkException;
import com.rappi.movies.data.network.RecyclerAdapter;
import com.rappi.movies.data.network.RequestCallback;
import com.rappi.movies.data.persistence.LocalStorage;
import com.rappi.movies.data.ui.LoadingDetailsActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFragment extends Fragment {
    List<Program> programs;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.programs_list_fragment, null);
        programs = getArguments()==null?new ArrayList<Program>():(ArrayList<Program>) getArguments().getSerializable(LocalStorage.LIST_STRING);
        layoutManager = new GridLayoutManager(view.getContext(), 3);
        recyclerView = view.findViewById(R.id.programs_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(programs);
        adapter.setOnClick(onItemClickListener());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private RecyclerAdapter.OnItemClicked onItemClickListener() {
        return new RecyclerAdapter.OnItemClicked() {
            @Override
            public void onItemClick(final int position) {
                LocalStorage.setSelectedProgram(programs.get(position));
                Intent intent = new Intent(getContext(), LoadingDetailsActivity.class);
                startActivity(intent);

            }
        };
    }
}
