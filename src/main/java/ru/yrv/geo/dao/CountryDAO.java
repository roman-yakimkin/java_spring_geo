package ru.yrv.geo.dao;

import ru.yrv.geo.model.Country;

import java.util.List;

public interface CountryDAO {
    public List<Country> getAll();
    public Country get(int id);
    public void delete(int id);
    public void save(Country country);
}
