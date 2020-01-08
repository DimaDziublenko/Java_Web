package com.itea.tasks.entities;

import static org.junit.Assert.assertNotNull;

public class EntitiesQueryTest {

    private static EntitiesQuery entitiesQuery = new EntitiesQuery();

    public void selectTheMostExpensiveProjectBasedOnDevelopersSalaryShouldWorkCorrectly() {
        Project project = entitiesQuery.selectTheMostExpensiveProjectBasedOnDevelopersSalary();
        assertNotNull(project);
    }

    public void selectTotalSalaryOnlyJavaDevelopersShouldWorkCorrectly() {
        Double totalSalary = entitiesQuery.selectTotalSalaryOnlyJavaDevelopers();
        assertNotNull(totalSalary);
    }

    public void selectTheMostCheapestProjectBasedOnCostShouldWorkCorrectly() {
        Project project = entitiesQuery.selectTheMostCheapestProjectBasedOnCost();
        assertNotNull(project);
    }

    public void selectAvgSalaryInTheMostCheapestProjectShouldWorkCorrectly() {
        Double avgSalary = entitiesQuery.selectAvgSalaryInTheMostCheapestProject();
        assertNotNull(avgSalary);
    }
}
