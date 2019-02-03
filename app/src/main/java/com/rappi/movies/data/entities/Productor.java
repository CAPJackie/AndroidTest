package com.rappi.movies.data.entities;

import java.io.Serializable;
import java.util.Objects;

public class Productor implements Serializable
{

    private Integer id;
    private String creditId;
    private String name;
    private Integer gender;
    private String profilePath;
    private final static long serialVersionUID = -7380143870491787932L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Productor() {
    }

    /**
     *
     * @param id
     * @param profilePath
     * @param name
     * @param gender
     * @param creditId
     */
    public Productor(Integer id, String creditId, String name, Integer gender, String profilePath) {
        super();
        this.id = id;
        this.creditId = creditId;
        this.name = name;
        this.gender = gender;
        this.profilePath = profilePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productor productor = (Productor) o;
        return Objects.equals(id, productor.id) &&
                Objects.equals(creditId, productor.creditId) &&
                Objects.equals(name, productor.name) &&
                Objects.equals(gender, productor.gender) &&
                Objects.equals(profilePath, productor.profilePath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, creditId, name, gender, profilePath);
    }

    @Override
    public String toString() {
        return "Productor{" +
                "id=" + id +
                ", creditId='" + creditId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", profilePath='" + profilePath + '\'' +
                '}';
    }
}