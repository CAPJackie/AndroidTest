package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.Objects;

public class Network implements Serializable
{

    private String name;
    private Integer id;
    private String logoPath;
    private String originCountry;
    private final static long serialVersionUID = -8200189702078511772L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Network() {
    }

    /**
     *
     * @param id
     * @param originCountry
     * @param name
     * @param logoPath
     */
    public Network(String name, Integer id, String logoPath, String originCountry) {
        super();
        this.name = name;
        this.id = id;
        this.logoPath = logoPath;
        this.originCountry = originCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }


    @Override
    public String toString() {
        return "Network{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", logoPath='" + logoPath + '\'' +
                ", originCountry='" + originCountry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return Objects.equals(name, network.name) &&
                Objects.equals(id, network.id) &&
                Objects.equals(logoPath, network.logoPath) &&
                Objects.equals(originCountry, network.originCountry);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id, logoPath, originCountry);
    }
}