package org.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.example.db.HibernateUtil;
import org.example.model.Client;

import java.util.Optional;

public class ClientDao implements Dao<Client, Long> {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public void save(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.persist(client);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Fail to save client", e);
            }
        }
    }

    @Override
    public Optional<Client> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.find(Client.class, id));
        }
    }

    @Override
    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(client);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Fail to update client", e);
            }
        }
    }

    @Override
    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.remove(client);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Fail to delete client", e);
            }
        }
    }
}