package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Movie implements Serializable {
    private int id;
    private String backdrop_path;
    private String poster_path;

    private boolean adult;
    private MovieCollection belongs_to_collection;
    private int budget;
    private List<Genre> genres;
    private String homepage;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private List<Company> production_companies;
    private List<Country> production_countries;
    private String release_date;
    private int revenue;
    private int runtime;
    private List<Language> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;


    private List<Video> results;

    public Movie() {
    }

    public Movie(int id, String backdrop_path, String poster_path, boolean adult, MovieCollection belongs_to_collection, int budget, List<Genre> genres, String homepage, String imdb_id, String original_language, String original_title, String overview, double popularity, List<Company> production_companies, List<Country> production_countries, String release_date, int revenue, int runtime, List<Language> spoken_languages, String status, String tagline, String title, boolean video, double vote_average, int vote_count, List<Video> results) {
        this.id = id;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.adult = adult;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.results = results;
    }

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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<Company> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Company> production_companies) {
        this.production_companies = production_companies;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public List<Video> getResults() {
        return results;
    }

    public void setResults(List<Video> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                adult == movie.adult &&
                budget == movie.budget &&
                Double.compare(movie.popularity, popularity) == 0 &&
                revenue == movie.revenue &&
                runtime == movie.runtime &&
                video == movie.video &&
                Double.compare(movie.vote_average, vote_average) == 0 &&
                vote_count == movie.vote_count &&
                Objects.equals(backdrop_path, movie.backdrop_path) &&
                Objects.equals(poster_path, movie.poster_path) &&
                Objects.equals(belongs_to_collection, movie.belongs_to_collection) &&
                Objects.equals(genres, movie.genres) &&
                Objects.equals(homepage, movie.homepage) &&
                Objects.equals(imdb_id, movie.imdb_id) &&
                Objects.equals(original_language, movie.original_language) &&
                Objects.equals(original_title, movie.original_title) &&
                Objects.equals(overview, movie.overview) &&
                Objects.equals(production_companies, movie.production_companies) &&
                Objects.equals(production_countries, movie.production_countries) &&
                Objects.equals(release_date, movie.release_date) &&
                Objects.equals(spoken_languages, movie.spoken_languages) &&
                Objects.equals(status, movie.status) &&
                Objects.equals(tagline, movie.tagline) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(results, movie.results);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, backdrop_path, poster_path, adult, belongs_to_collection, budget, genres, homepage, imdb_id, original_language, original_title, overview, popularity, production_companies, production_countries, release_date, revenue, runtime, spoken_languages, status, tagline, title, video, vote_average, vote_count, results);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", adult=" + adult +
                ", belongs_to_collection=" + belongs_to_collection +
                ", budget=" + budget +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", production_companies=" + production_companies +
                ", production_countries=" + production_countries +
                ", release_date='" + release_date + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spoken_languages=" + spoken_languages +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", results=" + results +
                '}';
    }
}
