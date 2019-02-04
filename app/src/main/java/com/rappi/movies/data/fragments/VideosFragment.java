package com.rappi.movies.data.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.entities.Video;
import com.rappi.movies.data.network.VideoAdapter;
import com.rappi.movies.data.persistence.LocalStorage;

import java.util.ArrayList;
import java.util.List;

public class VideosFragment extends Fragment {

    private RecyclerView recyclerView;

    private Program selectedProgram;
    private VideoAdapter adapter;
    private List<Video> videos = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videos_fragment, null);
        selectedProgram = LocalStorage.getSelectedProgram();
        videos = selectedProgram.getResults();
        setRecyclerViewComponents(view);
        return view;
    }

    private void setRecyclerViewComponents(View view) {
        recyclerView = view.findViewById(R.id.videos_recycler_view);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        setListToAdapter();
    }

    private void setListToAdapter() {
        adapter = new VideoAdapter(videos);
        recyclerView.setAdapter(adapter);
    }
}
