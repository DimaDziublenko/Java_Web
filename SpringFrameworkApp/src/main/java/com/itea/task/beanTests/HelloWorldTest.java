package com.itea.task.beanTests;

import com.itea.task.beans.HelloWorld;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void helloWorldBeanShouldWorkCorrectly() {
        HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
        helloWorld.setMessage("Hello world!");
        Assert.assertSame(helloWorld.getMessage(), "Hello world!");
    }
}
