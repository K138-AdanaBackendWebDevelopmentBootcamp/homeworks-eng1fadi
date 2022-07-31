package utils;

//package org.hibernate.tutorial.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class HibernateUtil {
    @PersistenceContext
    static EntityManagerFactory emf=null;
    public static EntityManager buildSessionFactory() {
        emf = Persistence.createEntityManagerFactory("mysqlPU");
        return emf.createEntityManager();
    }
    public static void closeEntityManager(EntityManager em) {
        em.clear();
        em.close();
        emf.close();
    }


}

