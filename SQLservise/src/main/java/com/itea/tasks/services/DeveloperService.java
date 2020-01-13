package com.itea.tasks.services;

import com.itea.tasks.entities.DeveloperEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DeveloperService {

    private EntityManager em = Persistence.createEntityManagerFactory("postgres").createEntityManager();

    public DeveloperEntity add(DeveloperEntity developer) {
        em.getTransaction().begin();
        DeveloperEntity developerFromDB = em.merge(developer);
        em.getTransaction().commit();
        return developerFromDB;
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public DeveloperEntity get(int id) {
        return em.find(DeveloperEntity.class, id);
    }

    public void update(DeveloperEntity developer) {
        em.getTransaction().begin();
        em.merge(developer);
        em.getTransaction().commit();
    }
}
