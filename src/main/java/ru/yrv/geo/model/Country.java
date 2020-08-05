package ru.yrv.geo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * The class - country
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 04.08.2020
 * @version 1.0
 */
public class Country {
    private Integer id = 0;
    private String name;

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
