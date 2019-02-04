package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TvSearch extends Search implements Serializable  {
    private List<TvShow> results;

    public TvSearch() {
    }

    public TvSearch(int page, int total_results, int total_pages, List<TvShow> results) {
        super(page, total_results, total_pages);
        this.results = results;
    }

    public List<TvShow> getResults() {
        return results;
    }

    public void setResults(List<TvShow> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TvSearch tvSearch = (TvSearch) o;
        return Objects.equals(results, tvSearch.results);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), results);
    }

    @Override
    public String toString() {
        return "TvSearch{" +
                "results=" + results +
                '}';
    }
}
