package com.itea.tasks.entities;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class EntitiesQueryTest {

    private EntitiesQuery entitiesQuery = new EntitiesQuery();

    @Test
    public void selectTheMostExpensiveProjectBasedOnDevelopersSalaryShouldWorkCorrectly() {
        ProjectEntity project = entitiesQuery.selectTheMostExpensiveProjectBasedOnDevelopersSalary();
        assertNotNull(project);
    }

    @Test
    public void selectTotalSalaryOnlyJavaDevelopersShouldWorkCorrectly() {
        Double totalSalary = entitiesQuery.selectTotalSalaryOnlyJavaDevelopers();
        assertNotNull(totalSalary);
    }

    @Test
    public void selectTheMostCheapestProjectBasedOnCostShouldWorkCorrectly() {
        ProjectEntity project = entitiesQuery.selectTheMostCheapestProjectBasedOnCost();
        assertNotNull(project);
    }

    @Test
    public void selectAvgSalaryInTheMostCheapestProjectShouldWorkCorrectly() {
        Double avgSalary = entitiesQuery.selectAvgSalaryInTheMostCheapestProject();
        assertNotNull(avgSalary);
    }
}
