package com.itea.tasks.CRUDServices;

import com.itea.tasks.entities.Developer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DeveloperService {

    private EntityManager em = Persistence.createEntityManagerFactory("postgres").createEntityManager();

    public Developer add(Developer developer) {
        em.getTransaction().begin();
        Developer developerFromDB = em.merge(developer);
        em.getTransaction().commit();
        return developerFromDB;
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Developer get(int id) {
        return em.find(Developer.class, id);
    }

    public void update(Developer developer) {
        em.getTransaction().begin();
        em.merge(developer);
        em.getTransaction().commit();
    }
}
