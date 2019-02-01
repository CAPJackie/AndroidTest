package com.rappi.movies.data.network;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Video;
import com.rappi.movies.data.persistence.LocalStorage;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videos;


    public VideoAdapter(List<Video> videos){
        this.videos = videos;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_view, viewGroup, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        videoViewHolder.videoWeb.loadData(LocalStorage.YOUTUBE_URL_FIRST + videos.get(i).getKey() + LocalStorage.YOUTUBE_URL_SECOND, "text/html", "utf-8");
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView videoWeb;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoWeb = itemView.findViewById(R.id.video_item);
            videoWeb.setBackgroundColor(Color.BLACK);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient());
        }
    }
}
