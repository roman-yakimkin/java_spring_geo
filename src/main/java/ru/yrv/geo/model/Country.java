package ru.yrv.geo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The class - country
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 04.08.2020
 * @version 1.0
 */
public class Country {
    private Integer id = 0;
    private String name;
    private Set<City> cities = new HashSet<>();

    public int getId() {
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

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return id.equals(country.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
