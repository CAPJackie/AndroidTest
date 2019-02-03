package com.rappi.movies.data.entities;

import java.util.Objects;

public class Language {
    private String iso_639_1;
    private String name;

    public Language() {
    }

    public Language(String iso_639_1, String name) {
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(iso_639_1, language.iso_639_1) &&
                Objects.equals(name, language.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iso_639_1, name);
    }

    @Override
    public String toString() {
        return "Language{" +
                "iso_639_1='" + iso_639_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
