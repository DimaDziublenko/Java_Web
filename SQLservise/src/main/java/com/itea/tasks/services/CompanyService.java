package com.itea.tasks.services;

import com.itea.tasks.entities.CompanyEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CompanyService {

    private EntityManager em = Persistence.createEntityManagerFactory("postgres").createEntityManager();

    public CompanyEntity add(CompanyEntity company) {
        em.getTransaction().begin();
        CompanyEntity companyFromDB = em.merge(company);
        em.getTransaction().commit();
        return companyFromDB;
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public CompanyEntity get(int id) {
        return em.find(CompanyEntity.class, id);
    }

    public void update(CompanyEntity company) {
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
    }
}
