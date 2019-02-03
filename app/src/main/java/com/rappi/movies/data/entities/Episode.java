package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.Objects;

public class Episode implements Serializable
{
    private String airDate;
    private Integer episodeNumber;
    private Integer id;
    private String name;
    private String overview;
    private String productionCode;
    private Integer seasonNumber;
    private Integer showId;
    private String stillPath;
    private Double voteAverage;
    private Integer voteCount;
    private final static long serialVersionUID = -5697023952005980567L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Episode() {
    }

    /**
     *
     * @param stillPath
     * @param id
     * @param airDate
     * @param overview
     * @param productionCode
     * @param name
     * @param showId
     * @param voteAverage
     * @param seasonNumber
     * @param episodeNumber
     * @param voteCount
     */
    public Episode(String airDate, Integer episodeNumber, Integer id, String name, String overview, String productionCode, Integer seasonNumber, Integer showId, String stillPath, Double voteAverage, Integer voteCount) {
        super();
        this.airDate = airDate;
        this.episodeNumber = episodeNumber;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.productionCode = productionCode;
        this.seasonNumber = seasonNumber;
        this.showId = showId;
        this.stillPath = stillPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
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

    public String getProductionCode() {
        return productionCode;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getStillPath() {
        return stillPath;
    }

    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return Objects.equals(airDate, episode.airDate) &&
                Objects.equals(episodeNumber, episode.episodeNumber) &&
                Objects.equals(id, episode.id) &&
                Objects.equals(name, episode.name) &&
                Objects.equals(overview, episode.overview) &&
                Objects.equals(productionCode, episode.productionCode) &&
                Objects.equals(seasonNumber, episode.seasonNumber) &&
                Objects.equals(showId, episode.showId) &&
                Objects.equals(stillPath, episode.stillPath) &&
                Objects.equals(voteAverage, episode.voteAverage) &&
                Objects.equals(voteCount, episode.voteCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(airDate, episodeNumber, id, name, overview, productionCode, seasonNumber, showId, stillPath, voteAverage, voteCount);
    }

    @Override
    public String toString() {
        return "Episode{" +
                "airDate='" + airDate + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", productionCode='" + productionCode + '\'' +
                ", seasonNumber=" + seasonNumber +
                ", showId=" + showId +
                ", stillPath='" + stillPath + '\'' +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}