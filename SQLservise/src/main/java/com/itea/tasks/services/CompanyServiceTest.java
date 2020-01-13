package com.itea.tasks.services;

import com.itea.tasks.entities.CompanyEntity;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class CompanyServiceTest {

    CompanyService service = new CompanyService();

    @Test
    public void saveEntityFunctionShouldSaveCorrectly() {
        CompanyEntity company = new CompanyEntity();
        company.setTitle("test1");
        company.setIndustry("test1");
        service.add(company);
        assertSame(company, service.get(company.getId()));
    }

    @Test
    public void deleteEntityFunctionShouldDeleteCorrectly() {
        CompanyEntity company = new CompanyEntity();
        company.setTitle("test2");
        company.setIndustry("test2");
        service.add(company);
        service.delete(company.getId());
        assertNull(service.get(company.getId()));
    }

    @Test
    public void selectEntityFunctionShouldSelectCorrectly() {
        CompanyEntity company = new CompanyEntity();
        company.setTitle("test3");
        company.setIndustry("test3");
        service.add(company);
        assertSame(company, service.get(company.getId()));
    }

    @Test
    public void updateEntityFunctionShouldUpdateCorrectly() {
        CompanyEntity company = new CompanyEntity();
        company.setTitle("test4");
        company.setIndustry("test4");
        service.add(company);
        company.setTitle("test4.1");
        service.update(company);
        assertNotSame(company, service.get(company.getId()));
    }
}
