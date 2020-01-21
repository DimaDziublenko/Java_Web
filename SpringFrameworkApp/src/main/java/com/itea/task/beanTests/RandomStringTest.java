package com.itea.task.beanTests;

import com.itea.task.beans.RandomString;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class RandomStringTest {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void RandomStringBeanShouldWorkCorrectly() {
        RandomString randomString = applicationContext.getBean("randomString", RandomString.class);
        randomString.setSize(10);
        randomString.random();
        assertNotNull(randomString.getValue());
        assertSame(randomString.getSize(), 10);
        assertEquals(10, randomString.getValue().length());
    }
}
