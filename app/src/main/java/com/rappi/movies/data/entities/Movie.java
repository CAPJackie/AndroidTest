package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Movie extends Program implements Serializable {
    private boolean adult;
    private MovieCollection belongs_to_collection;
    private int budget;
    private String imdb_id;
    private String original_title;
    private List<Country> production_countries;
    private String release_date;
    private int revenue;
    private int runtime;
    private List<Language> spoken_languages;
    private String tagline;
    private String title;
    private boolean video;

    public Movie() {
    }

    public Movie(Integer id, String backdrop_path, String poster_path, List<Genre> genres, String homepage, String original_language, String overview, Double popularity, List<Company> production_companies, String status, Double vote_average, Integer vote_count, boolean adult, MovieCollection belongs_to_collection, int budget, String imdb_id, String original_title, List<Country> production_countries, String release_date, int revenue, int runtime, List<Language> spoken_languages, String tagline, String title, boolean video) {
        super(id, backdrop_path, poster_path, genres, homepage, original_language, overview, popularity, production_companies, status, vote_average, vote_count);
        this.adult = adult;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.imdb_id = imdb_id;
        this.original_title = original_title;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
    }


    public boolean isAdult() {

        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public MovieCollection getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(MovieCollection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public List<Country> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<Country> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<Language> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<Language> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "adult=" + adult +
                ", belongs_to_collection=" + belongs_to_collection +
                ", budget=" + budget +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_title='" + original_title + '\'' +
                ", production_countries=" + production_countries +
                ", release_date='" + release_date + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spoken_languages=" + spoken_languages +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return adult == movie.adult &&
                budget == movie.budget &&
                revenue == movie.revenue &&
                runtime == movie.runtime &&
                video == movie.video &&
                Objects.equals(belongs_to_collection, movie.belongs_to_collection) &&
                Objects.equals(imdb_id, movie.imdb_id) &&
                Objects.equals(original_title, movie.original_title) &&
                Objects.equals(production_countries, movie.production_countries) &&
                Objects.equals(release_date, movie.release_date) &&
                Objects.equals(spoken_languages, movie.spoken_languages) &&
                Objects.equals(tagline, movie.tagline) &&
                Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(adult, belongs_to_collection, budget, imdb_id, original_title, production_countries, release_date, revenue, runtime, spoken_languages, tagline, title, video);
    }
}
