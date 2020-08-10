package ru.yrv.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yrv.geo.model.City;

/**
 * The JPA repository for city entity
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 09.08.2020
 * @version 1.0
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
