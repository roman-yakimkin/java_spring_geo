package ru.yrv.geo.model;

import java.util.Objects;

/**
 * The class city
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 07.08.2020
 * @version 1.0
 */
public class City {
    private Integer id = 0;
    private String name;
    private Country country = new Country();

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getId(), city.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
