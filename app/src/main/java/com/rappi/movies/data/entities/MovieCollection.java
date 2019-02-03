package com.rappi.movies.data.entities;

import java.util.Objects;

public class MovieCollection {
    private int id;
    private String name;
    private String poster_path;
    private String backdrop_path;

    public MovieCollection() {
    }

    public MovieCollection(int id, String name, String poster_path, String backdrop_path) {

        this.id = id;
        this.name = name;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    @Override
    public String toString() {
        return "MovieCollection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCollection that = (MovieCollection) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(poster_path, that.poster_path) &&
                Objects.equals(backdrop_path, that.backdrop_path);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, poster_path, backdrop_path);
    }


}
