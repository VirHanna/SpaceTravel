package org.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.example.db.HibernateUtil;
import org.example.model.Planet;

import java.util.Optional;

public class PlanetDao implements Dao<Planet, String> {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public void save(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.persist(planet);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Fail to create planet", e);
            }
        }
    }

    @Override
    public Optional<Planet> getById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.find(Planet.class, id));
        }
    }

    @Override
    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(planet);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Fail to update planet", e);
            }
        }
    }

    @Override
    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.remove(planet);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Fail to delete planet", e);
            }
        }
    }
}
