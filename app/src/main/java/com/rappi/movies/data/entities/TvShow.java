package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TvShow extends Program implements Serializable {

    private List<Productor> created_by;
    private List<Integer> episode_run_time;
    private String first_air_date;
    private Boolean in_production;
    private List<String> languages;
    private String last_air_date;
    private Episode last_episode_to_air;
    private String name;
    private Episode next_episode_to_air;
    private List<Network> networks;
    private Integer number_of_episodes;
    private Integer number_of_seasons;
    private List<String> origin_country;
    private String original_name;
    private List<Season> seasons;
    private String type;
    private final static long serialVersionUID = -493996423190927632L;

    public TvShow(){}

    public TvShow(Integer id, String backdrop_path, String poster_path, List<Genre> genres, String homepage, String original_language, String overview, Double popularity, List<Company> production_companies, String status, Double vote_average, Integer vote_count, List<Productor> created_by, List<Integer> episode_run_time, String first_air_date, Boolean in_production, List<String> languages, String last_air_date, Episode last_episode_to_air, String name, Episode next_episode_to_air, List<Network> networks, Integer number_of_episodes, Integer number_of_seasons, List<String> origin_country, String original_name, List<Season> seasons, String type) {
        super(id, backdrop_path, poster_path, genres, homepage, original_language, overview, popularity, production_companies, status, vote_average, vote_count);
        this.created_by = created_by;
        this.episode_run_time = episode_run_time;
        this.first_air_date = first_air_date;
        this.in_production = in_production;
        this.languages = languages;
        this.last_air_date = last_air_date;
        this.last_episode_to_air = last_episode_to_air;
        this.name = name;
        this.next_episode_to_air = next_episode_to_air;
        this.networks = networks;
        this.number_of_episodes = number_of_episodes;
        this.number_of_seasons = number_of_seasons;
        this.origin_country = origin_country;
        this.original_name = original_name;
        this.seasons = seasons;
        this.type = type;
    }

    public List<Productor> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(List<Productor> created_by) {
        this.created_by = created_by;
    }

    public List<Integer> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(List<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public Boolean getIn_production() {
        return in_production;
    }

    public void setIn_production(Boolean in_production) {
        this.in_production = in_production;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public Episode getLast_episode_to_air() {
        return last_episode_to_air;
    }

    public void setLast_episode_to_air(Episode last_episode_to_air) {
        this.last_episode_to_air = last_episode_to_air;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Episode getNext_episode_to_air() {
        return next_episode_to_air;
    }

    public void setNext_episode_to_air(Episode next_episode_to_air) {
        this.next_episode_to_air = next_episode_to_air;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public Integer getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(Integer number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public Integer getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(Integer number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TvShow tvShow = (TvShow) o;
        return Objects.equals(created_by, tvShow.created_by) &&
                Objects.equals(episode_run_time, tvShow.episode_run_time) &&
                Objects.equals(first_air_date, tvShow.first_air_date) &&
                Objects.equals(in_production, tvShow.in_production) &&
                Objects.equals(languages, tvShow.languages) &&
                Objects.equals(last_air_date, tvShow.last_air_date) &&
                Objects.equals(last_episode_to_air, tvShow.last_episode_to_air) &&
                Objects.equals(name, tvShow.name) &&
                Objects.equals(next_episode_to_air, tvShow.next_episode_to_air) &&
                Objects.equals(networks, tvShow.networks) &&
                Objects.equals(number_of_episodes, tvShow.number_of_episodes) &&
                Objects.equals(number_of_seasons, tvShow.number_of_seasons) &&
                Objects.equals(origin_country, tvShow.origin_country) &&
                Objects.equals(original_name, tvShow.original_name) &&
                Objects.equals(seasons, tvShow.seasons) &&
                Objects.equals(type, tvShow.type);
    }

    @Override
    public String toString() {
        return "TvShow{" +
                "created_by=" + created_by +
                ", episode_run_time=" + episode_run_time +
                ", first_air_date='" + first_air_date + '\'' +
                ", in_production=" + in_production +
                ", languages=" + languages +
                ", last_air_date='" + last_air_date + '\'' +
                ", last_episode_to_air=" + last_episode_to_air +
                ", name='" + name + '\'' +
                ", next_episode_to_air=" + next_episode_to_air +
                ", networks=" + networks +
                ", number_of_episodes=" + number_of_episodes +
                ", number_of_seasons=" + number_of_seasons +
                ", origin_country=" + origin_country +
                ", original_name='" + original_name + '\'' +
                ", seasons=" + seasons +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(created_by, episode_run_time, first_air_date, in_production, languages, last_air_date, last_episode_to_air, name, next_episode_to_air, networks, number_of_episodes, number_of_seasons, origin_country, original_name, seasons, type);
    }
}