package com.rappi.movies.data.entities;

public class Movie {
    private int id;

    private String backdrop_path;

    public Movie(){}

    public Movie(int id, String backdrop_path) {
        this.backdrop_path = backdrop_path;
        this.id = id;
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
