package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.List;

public class Program implements Serializable {

    private Integer id;
    private String backdrop_path;
    private String poster_path;
    private List<Genre> genres;
    private String homepage;
    private String original_language;
    private String overview;
    private Double popularity;
    private List<Company> production_companies;
    private String status;
    private Double vote_average;
    private Integer vote_count;
    private List<Video> results;

    public Program(){}

    public Program(Integer id, String backdrop_path, String poster_path, List<Genre> genres, String homepage, String original_language, String overview, Double popularity, List<Company> production_companies, String status, Double vote_average, Integer vote_count) {

        this.id = id;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.genres = genres;
        this.homepage = homepage;
        this.original_language = original_language;
        this.overview = overview;
        this.popularity = popularity;
        this.production_companies = production_companies;
        this.status = status;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }


    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
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

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public List<Company> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Company> production_companies) {
        this.production_companies = production_companies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public List<Video> getResults() {
        return results;
    }

    public void setResults(List<Video> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", original_language='" + original_language + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", production_companies=" + production_companies +
                ", status='" + status + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", results=" + results +
                '}';
    }
}
