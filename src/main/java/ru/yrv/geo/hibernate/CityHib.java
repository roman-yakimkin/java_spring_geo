package ru.yrv.geo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.yrv.geo.dao.CityDAO;
import ru.yrv.geo.model.City;

import java.util.List;

/**
 * The hibernate for the city entity
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 07.08.2020
 * @version 1.0
 */
public class CityHib implements CityDAO {
    private final SessionFactory sf;

    public CityHib(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<City> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from ru.yrv.geo.model.City order by name", City.class)
                    .list();
        }
    }

    @Override
    public City get(int id) {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from ru.yrv.geo.model.City where id = :id", City.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sf.openSession()) {
            City city = new City();
            city.setId(id);
            session.beginTransaction();
            session.delete(city);
            session.getTransaction().commit();
        }
    }

    @Override
    public void save(City city) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            if (city.getId() == 0){
                city.setId(null);
                session.save(city);
            } else {
                session.update(city);
            }
            session.getTransaction().commit();
        }
    }
}
