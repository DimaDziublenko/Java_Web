package com.itea.tasks.CRUDServices;

import com.itea.tasks.entities.Company;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class CompanyServiceTest {

    CompanyService service = new CompanyService();

    @Test
    public void saveEntityFunctionShouldSaveCorrectly() {
        Company company = new Company();
        company.setTitle("test1");
        company.setIndustry("test1");
        service.add(company);
        assertSame(company, service.get(company.getId()));
    }

    @Test
    public void deleteEntityFunctionShouldDeleteCorrectly() {
        Company company = new Company();
        company.setTitle("test2");
        company.setIndustry("test2");
        service.add(company);
        service.delete(company.getId());
        assertNull(service.get(company.getId()));
    }

    @Test
    public void selectEntityFunctionShouldSelectCorrectly() {
        Company company = new Company();
        company.setTitle("test3");
        company.setIndustry("test3");
        service.add(company);
        assertSame(company, service.get(company.getId()));
    }

    @Test
    public void updateEntityFunctionShouldUpdateCorrectly() {
        Company company = new Company();
        company.setTitle("test4");
        company.setIndustry("test4");
        service.add(company);
        company.setTitle("test4.1");
        service.update(company);
        assertNotSame(company, service.get(company.getId()));
    }
}
