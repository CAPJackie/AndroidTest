package com.rappi.movies.data.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.network.RecyclerAdapter;

import java.util.ArrayList;
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
        programs = (ArrayList<Program>) getArguments().getSerializable("list");
        layoutManager = new GridLayoutManager(view.getContext(), 3);
        recyclerView = view.findViewById(R.id.programs_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(programs);
        adapter.setOnClick(onItemClickListener(view));
        recyclerView.setAdapter(adapter);
        return view;
    }

    private RecyclerAdapter.OnItemClicked onItemClickListener(View view) {
        return new RecyclerAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {

            }
        };
    }
}
