package com.itea.task.controllerTests;

import com.itea.task.configs.DataConfig;
import com.itea.task.controllers.CompanyController;
import com.itea.task.dtos.CompanyDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpStatus.OK;

@DirtiesContext
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class CompanyControllerTest {

    @Autowired
    private CompanyController controller;

    private CompanyDto company;

    @Test
    public void getCompanyShouldWorkCorrectly() {
        company = new CompanyDto(1L, "getCompanyTest", new Date(), 11.11F);
        controller.addCompany(company);
        assertEquals(OK, controller.getCompany(1L).getStatusCode());
    }

    @Test
    public void getCompaniesShouldWorkCorrectly() {
        company = new CompanyDto(2L, "getCompaniesTest", new Date(), 22.22F);
        controller.addCompany(company);
        List<CompanyDto> companies = controller.getCompanies();
        assertNotNull(companies.get(0));
    }

    @Test
    public void addCompanyShouldWorkCorrectly() {
        company = new CompanyDto(3L, "addCompanyTest", new Date(), 33.33F);
        assertEquals(OK, controller.addCompany(company).getStatusCode());
    }

    @Test
    public void deleteCompanyShouldWorkCorrectly() {
        company = new CompanyDto(4L, "deleteCompanyTest", new Date(), 44.44F);
        controller.addCompany(company);
        assertEquals(OK, controller.deleteCompany(4L).getStatusCode());
    }

    @Test
    public void updateCompanyShouldWorkCorrectly() {
        company = new CompanyDto(5L, "updateCompanyTest", new Date(), 55.55F);
        controller.addCompany(company);
        assertEquals(OK, controller.updateCompany(6L, company).getStatusCode());
    }
}
