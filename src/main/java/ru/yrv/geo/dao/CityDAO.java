package ru.yrv.geo.dao;

import ru.yrv.geo.model.City;
import ru.yrv.geo.model.Country;

import java.util.List;

public interface CityDAO {
    public List<City> getAll();
    public City get(int id);
    public void delete(int id);
    public void save(City city);
}
