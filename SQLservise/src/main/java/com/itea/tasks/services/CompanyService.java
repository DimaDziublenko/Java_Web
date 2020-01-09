package com.itea.tasks.services;

import com.itea.tasks.entities.Company;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CompanyService {

    private EntityManager em = Persistence.createEntityManagerFactory("postgres").createEntityManager();

    public Company add(Company company) {
        em.getTransaction().begin();
        Company companyFromDB = em.merge(company);
        em.getTransaction().commit();
        return companyFromDB;
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Company get(int id) {
        return em.find(Company.class, id);
    }

    public void update(Company company) {
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
    }
}
