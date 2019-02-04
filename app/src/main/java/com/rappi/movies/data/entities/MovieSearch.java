package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MovieSearch extends Search implements Serializable {
    private List<Movie> results;

    public MovieSearch(){}


    public MovieSearch(int page, int total_results, int total_pages, List<Movie> results) {
        super(page, total_results, total_pages);
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MovieSearch that = (MovieSearch) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), results);
    }

    @Override
    public String toString() {
        return "MovieSearch{" +
                "results=" + results +
                '}';
    }
}
