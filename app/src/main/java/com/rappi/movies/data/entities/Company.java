package com.rappi.movies.data.entities;

import java.util.Objects;

public class Company {
    private int id;
    private String logo_path;
    private String name;
    private String origin_country;

    public Company() {
    }

    public Company(int id, String logo_path, String name, String origin_country) {
        this.id = id;
        this.logo_path = logo_path;
        this.name = name;
        this.origin_country = origin_country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id &&
                Objects.equals(logo_path, company.logo_path) &&
                Objects.equals(name, company.name) &&
                Objects.equals(origin_country, company.origin_country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logo_path, name, origin_country);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", logo_path='" + logo_path + '\'' +
                ", name='" + name + '\'' +
                ", origin_country='" + origin_country + '\'' +
                '}';
    }
}
