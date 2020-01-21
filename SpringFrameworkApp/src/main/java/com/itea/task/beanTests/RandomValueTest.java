package com.itea.task.beanTests;

import com.itea.task.beans.RandomValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RandomValueTest {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void RandomValueBeanShouldWorkCorrectly() {
        RandomValue randomValue = applicationContext.getBean("randomValue", RandomValue.class);
        randomValue.setMin(10);
        randomValue.setMax(100);
        randomValue.random();
        assertNotNull(randomValue.getValue());
        assertTrue((randomValue.getValue() > 10) && (randomValue.getValue() < 100));
    }
}
