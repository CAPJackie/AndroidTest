package com.rappi.movies.data.entities;

import java.util.List;
import java.util.Objects;

public class Search {
    private int page;
    private int total_results;
    private int total_pages;
    private List<Program> results;

    public Search(){}

    public Search(int page, int total_results, int total_pages, List<Program> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Program> getResults() {
        return results;
    }

    public void setResults(List<Program> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Search{" +
                "page=" + page +
                ", total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", results=" + results +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search that = (Search) o;
        return page == that.page &&
                total_results == that.total_results &&
                total_pages == that.total_pages &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {

        return Objects.hash(page, total_results, total_pages, results);
    }
}
