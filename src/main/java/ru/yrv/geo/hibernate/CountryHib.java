package ru.yrv.geo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.yrv.geo.dao.CountryDAO;
import ru.yrv.geo.model.Country;

import java.util.List;

/**
 * The hibernate for the country entity
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 04.08.2020
 * @version 1.0
 */
public class CountryHib implements CountryDAO {
    private final SessionFactory sf;

    public CountryHib(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Country> getAll(){
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from ru.yrv.geo.model.Country order by name", Country.class)
                    .list();
        }
    }

    public Country get(int id) {
        try (Session session = sf.openSession()) {
            return session
                .createQuery("from ru.yrv.geo.model.Country where id = :id", Country.class)
                .setParameter("id", id)
                .uniqueResult();
        }
    }

    public void save(Country country) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            if (country.getId() == 0){
                country.setId(null);
                session.save(country);
            } else {
                session.update(country);
            }
            session.getTransaction().commit();
        }
    }

    public void delete(int id) {
        try (Session session = sf.openSession()) {
            Country country = new Country();
            country.setId(id);
            session.beginTransaction();
            session.delete(country);
            session.getTransaction().commit();
        }
    }
}
