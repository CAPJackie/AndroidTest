package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TvShow extends Program implements Serializable {

    private String backdropPath;
    private List<Productor> createdBy;
    private List<Integer> episodeRunTime;
    private String firstAirDate;
    private List<Genre> genres;
    private String homepage;
    private Integer id;
    private Boolean inProduction;
    private List<String> languages;
    private String lastAirDate;
    private Episode lastEpisodeToAir;
    private String name;
    private Episode nextEpisodeToAir;
    private List<Network> networks;
    private Integer numberOfEpisodes;
    private Integer numberOfSeasons;
    private List<String> originCountry;
    private String originalLanguage;
    private String originalName;
    private String overview;
    private Double popularity;
    private String posterPath;
    private List<Company> productionCompanies;
    private List<Season> seasons;
    private String status;
    private String type;
    private Double voteAverage;
    private Integer voteCount;
    private final static long serialVersionUID = -493996423190927632L;

    /**
     * No args constructor for use in serialization
     */
    public TvShow() {
    }

    /**
     * @param genres
     * @param originalName
     * @param type
     * @param backdropPath
     * @param voteCount
     * @param id
     * @param nextEpisodeToAir
     * @param numberOfEpisodes
     * @param languages
     * @param originCountry
     * @param inProduction
     * @param name
     * @param posterPath
     * @param voteAverage
     * @param popularity
     * @param networks
     * @param status
     * @param lastAirDate
     * @param lastEpisodeToAir
     * @param numberOfSeasons
     * @param originalLanguage
     * @param homepage
     * @param createdBy
     * @param overview
     * @param seasons
     * @param firstAirDate
     * @param productionCompanies
     * @param episodeRunTime
     */
    public TvShow(String backdropPath, List<Productor> createdBy, List<Integer> episodeRunTime, String firstAirDate, List<Genre> genres, String homepage, Integer id, Boolean inProduction, List<String> languages, String lastAirDate, Episode lastEpisodeToAir, String name, Episode nextEpisodeToAir, List<Network> networks, Integer numberOfEpisodes, Integer numberOfSeasons, List<String> originCountry, String originalLanguage, String originalName, String overview, Double popularity, String posterPath, List<Company> productionCompanies, List<Season> seasons, String status, String type, Double voteAverage, Integer voteCount) {
        super();
        this.backdropPath = backdropPath;
        this.createdBy = createdBy;
        this.episodeRunTime = episodeRunTime;
        this.firstAirDate = firstAirDate;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.inProduction = inProduction;
        this.languages = languages;
        this.lastAirDate = lastAirDate;
        this.lastEpisodeToAir = lastEpisodeToAir;
        this.name = name;
        this.nextEpisodeToAir = nextEpisodeToAir;
        this.networks = networks;
        this.numberOfEpisodes = numberOfEpisodes;
        this.numberOfSeasons = numberOfSeasons;
        this.originCountry = originCountry;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.seasons = seasons;
        this.status = status;
        this.type = type;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Productor> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<Productor> createdBy) {
        this.createdBy = createdBy;
    }

    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getInProduction() {
        return inProduction;
    }

    public void setInProduction(Boolean inProduction) {
        this.inProduction = inProduction;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public Episode getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }

    public void setLastEpisodeToAir(Episode lastEpisodeToAir) {
        this.lastEpisodeToAir = lastEpisodeToAir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Episode getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }

    public void setNextEpisodeToAir(Episode nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<Company> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<Company> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        TvShow tvShow = (TvShow) o;
        return Objects.equals(backdropPath, tvShow.backdropPath) &&
                Objects.equals(createdBy, tvShow.createdBy) &&
                Objects.equals(episodeRunTime, tvShow.episodeRunTime) &&
                Objects.equals(firstAirDate, tvShow.firstAirDate) &&
                Objects.equals(genres, tvShow.genres) &&
                Objects.equals(homepage, tvShow.homepage) &&
                Objects.equals(id, tvShow.id) &&
                Objects.equals(inProduction, tvShow.inProduction) &&
                Objects.equals(languages, tvShow.languages) &&
                Objects.equals(lastAirDate, tvShow.lastAirDate) &&
                Objects.equals(lastEpisodeToAir, tvShow.lastEpisodeToAir) &&
                Objects.equals(name, tvShow.name) &&
                Objects.equals(nextEpisodeToAir, tvShow.nextEpisodeToAir) &&
                Objects.equals(networks, tvShow.networks) &&
                Objects.equals(numberOfEpisodes, tvShow.numberOfEpisodes) &&
                Objects.equals(numberOfSeasons, tvShow.numberOfSeasons) &&
                Objects.equals(originCountry, tvShow.originCountry) &&
                Objects.equals(originalLanguage, tvShow.originalLanguage) &&
                Objects.equals(originalName, tvShow.originalName) &&
                Objects.equals(overview, tvShow.overview) &&
                Objects.equals(popularity, tvShow.popularity) &&
                Objects.equals(posterPath, tvShow.posterPath) &&
                Objects.equals(productionCompanies, tvShow.productionCompanies) &&
                Objects.equals(seasons, tvShow.seasons) &&
                Objects.equals(status, tvShow.status) &&
                Objects.equals(type, tvShow.type) &&
                Objects.equals(voteAverage, tvShow.voteAverage) &&
                Objects.equals(voteCount, tvShow.voteCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(backdropPath, createdBy, episodeRunTime, firstAirDate, genres, homepage, id, inProduction, languages, lastAirDate, lastEpisodeToAir, name, nextEpisodeToAir, networks, numberOfEpisodes, numberOfSeasons, originCountry, originalLanguage, originalName, overview, popularity, posterPath, productionCompanies, seasons, status, type, voteAverage, voteCount);
    }

    @Override
    public String toString() {
        return "TvShow{" +
                "backdropPath='" + backdropPath + '\'' +
                ", createdBy=" + createdBy +
                ", episodeRunTime=" + episodeRunTime +
                ", firstAirDate='" + firstAirDate + '\'' +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", inProduction=" + inProduction +
                ", languages=" + languages +
                ", lastAirDate='" + lastAirDate + '\'' +
                ", lastEpisodeToAir=" + lastEpisodeToAir +
                ", name='" + name + '\'' +
                ", nextEpisodeToAir=" + nextEpisodeToAir +
                ", networks=" + networks +
                ", numberOfEpisodes=" + numberOfEpisodes +
                ", numberOfSeasons=" + numberOfSeasons +
                ", originCountry=" + originCountry +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalName='" + originalName + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", productionCompanies=" + productionCompanies +
                ", seasons=" + seasons +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}