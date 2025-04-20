package org.example.db;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;

public class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    @Getter
    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
