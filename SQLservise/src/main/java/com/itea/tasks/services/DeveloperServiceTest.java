package com.itea.tasks.services;

import com.itea.tasks.entities.Developer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class DeveloperServiceTest {

    DeveloperService service = new DeveloperService();

    @Test
    public void saveEntityFunctionShouldSaveCorrectly() {
        Developer developer = new Developer();
        developer.setName("test1");
        developer.setAge(1);
        developer.setGender("test1");
        developer.setSalary(1.1);
        service.add(developer);
        assertSame(developer, service.get(developer.getId()));
    }

    @Test
    public void deleteEntityFunctionShouldDeleteCorrectly() {
        Developer developer = new Developer();
        developer.setName("test2");
        developer.setAge(2);
        developer.setGender("test2");
        developer.setSalary(2.2);
        service.add(developer);
        service.delete(developer.getId());
        assertNull(service.get(developer.getId()));
    }

    @Test
    public void selectEntityFunctionShouldSelectCorrectly() {
        Developer developer = new Developer();
        developer.setName("test3");
        developer.setAge(3);
        developer.setGender("test3");
        developer.setSalary(3.3);
        service.add(developer);
        assertSame(developer, service.get(developer.getId()));
    }

    @Test
    public void updateEntityFunctionShouldUpdateCorrectly() {
        Developer developer = new Developer();
        developer.setName("test4");
        developer.setAge(4);
        developer.setGender("test4");
        developer.setSalary(4.4);
        service.add(developer);
        developer.setName("test4.1");
        service.update(developer);
        assertNotSame(developer, service.get(developer.getId()));
    }
}
