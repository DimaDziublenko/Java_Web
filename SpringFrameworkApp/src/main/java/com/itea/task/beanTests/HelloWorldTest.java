package com.itea.task.beanTests;

import com.itea.task.beans.Service;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void helloWorldBeanShouldWorkCorrectly() {
        Service helloWorld = applicationContext.getBean("helloWorld", Service.class);
        helloWorld.setMessage("Hello world!");
        Assert.assertSame(helloWorld.getMessage(), "Hello world!");
    }
}
