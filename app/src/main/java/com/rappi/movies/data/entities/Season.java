package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.Objects;

public class Season implements Serializable
{

    private String airDate;
    private Integer episodeCount;
    private Integer id;
    private String name;
    private String overview;
    private String posterPath;
    private Integer seasonNumber;
    private final static long serialVersionUID = -6210944446313511528L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Season() {
    }

    /**
     *
     * @param id
     * @param airDate
     * @param overview
     * @param posterPath
     * @param name
     * @param episodeCount
     * @param seasonNumber
     */
    public Season(String airDate, Integer episodeCount, Integer id, String name, String overview, String posterPath, Integer seasonNumber) {
        super();
        this.airDate = airDate;
        this.episodeCount = episodeCount;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.posterPath = posterPath;
        this.seasonNumber = seasonNumber;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Integer getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return Objects.equals(airDate, season.airDate) &&
                Objects.equals(episodeCount, season.episodeCount) &&
                Objects.equals(id, season.id) &&
                Objects.equals(name, season.name) &&
                Objects.equals(overview, season.overview) &&
                Objects.equals(posterPath, season.posterPath) &&
                Objects.equals(seasonNumber, season.seasonNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(airDate, episodeCount, id, name, overview, posterPath, seasonNumber);
    }

    @Override
    public String toString() {
        return "Season{" +
                "airDate='" + airDate + '\'' +
                ", episodeCount=" + episodeCount +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", seasonNumber=" + seasonNumber +
                '}';
    }
}