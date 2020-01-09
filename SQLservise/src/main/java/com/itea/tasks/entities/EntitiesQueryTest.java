package com.itea.tasks.entities;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class EntitiesQueryTest {

    private static EntitiesQuery entitiesQuery = new EntitiesQuery();

    @Test
    public void selectTheMostExpensiveProjectBasedOnDevelopersSalaryShouldWorkCorrectly() {
        Project project = entitiesQuery.selectTheMostExpensiveProjectBasedOnDevelopersSalary();
        assertNotNull(project);
    }

    @Test
    public void selectTotalSalaryOnlyJavaDevelopersShouldWorkCorrectly() {
        Double totalSalary = entitiesQuery.selectTotalSalaryOnlyJavaDevelopers();
        assertNotNull(totalSalary);
    }

    @Test
    public void selectTheMostCheapestProjectBasedOnCostShouldWorkCorrectly() {
        Project project = entitiesQuery.selectTheMostCheapestProjectBasedOnCost();
        assertNotNull(project);
    }

    @Test
    public void selectAvgSalaryInTheMostCheapestProjectShouldWorkCorrectly() {
        Double avgSalary = entitiesQuery.selectAvgSalaryInTheMostCheapestProject();
        assertNotNull(avgSalary);
    }
}
