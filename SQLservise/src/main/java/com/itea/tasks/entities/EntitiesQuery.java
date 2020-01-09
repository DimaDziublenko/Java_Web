package com.itea.tasks.entities;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntitiesQuery {

    private static EntityManager em = Persistence.createEntityManagerFactory("postgres").createEntityManager();
    private static Query query;

    public Project selectTheMostExpensiveProjectBasedOnDevelopersSalary() {
        query = em.createQuery("SELECT p.id, p.title, p.industry, p.deadline\n" +
                "FROM projects AS p\n" +
                "INNER JOIN developer_project AS dp ON p.id = dp.project_id\n" +
                "INNER JOIN developers AS d ON dp.developer_id = d.id\n" +
                "GROUP BY p.id, dp.developer_id, dp.project_id, d.id\n" +
                "ORDER BY SUM(d.salary) DESC");
        return (Project) query.getResultList().get(0);
    }

    public Double selectTotalSalaryOnlyJavaDevelopers() {
        query = em.createQuery("SELECT SUM(d.salary)\n" +
                "FROM developers AS d\n" +
                "INNER JOIN developer_skill AS ds ON d.id = ds.developer_id\n" +
                "INNER JOIN skills AS s ON ds.skill_id = s.id\n" +
                "WHERE s.industry = 'Java'");
        return (Double) query.getResultList().get(0);
    }

    public Project selectTheMostCheapestProjectBasedOnCost() {
        query = em.createQuery("SELECT p.id, p.title, p.industry, p.cost\nFROM projects AS p\nORDER BY p.cost");
        return (Project) query.getResultList().get(0);
    }

    public Double selectAvgSalaryInTheMostCheapestProject() {
        query = em.createQuery("SELECT AVG(d.salary)\n" +
                "FROM developers AS d\n" +
                "INNER JOIN developer_project dp ON d.id = dp.developer_id\n" +
                "INNER JOIN projects p ON dp.project_id = p.id\n" +
                "GROUP BY p.cost\n" +
                "HAVING MIN(p.cost) = p.cost");
        return (Double)query.getResultList().get(0);
    }
}
