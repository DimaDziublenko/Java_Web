package com.itea.task.controllerTests;

import com.itea.task.controllers.CompanyController;
import com.itea.task.dtos.CompanyDto;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.OK;

@Component
public class CompanyControllerTest {

    @Autowired
    private static CompanyController controller;

    private static CompanyDto company;

    @BeforeClass
    public static void setUp() {
        company = new CompanyDto(1L, "test1", new Date(), 1.1F);
        controller.addCompany(company);
    }

    @Test
    public void getCompaniesRequestShouldWorkCorrectly() {
        List<CompanyDto> dtos = controller.getCompanies();
        assertEquals(company, dtos.get(0));
    }

    @Test
    public void getCompanyRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(company, OK), controller.getCompany(1L));
    }

    @Test
    public void addCompanyRequestShouldWorkCorrectly() {
        controller.deleteCompany(1L);
        assertEquals(new ResponseEntity<>(company, OK), controller.addCompany(company));
    }

    @Test
    public void deleteCompanyRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(1L, OK), controller.deleteCompany(1L));
        controller.addCompany(company);
    }

    @Test
    public void updateCompanyRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(company, OK), controller.updateCompany(1L, company));
    }
}
