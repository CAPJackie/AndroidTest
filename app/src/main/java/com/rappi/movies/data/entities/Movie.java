package com.rappi.movies.data.entities;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;

    private String backdrop_path;
    private String poster_path;

    public Movie(){}

    public Movie(int id, String backdrop_path, String poster_path) {
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}
