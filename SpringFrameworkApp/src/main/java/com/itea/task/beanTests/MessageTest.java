package com.itea.task.beanTests;

import com.itea.task.beans.Message;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertSame;

public class MessageTest {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void messageBeanShouldWorkCorrectly() {
        Message message = applicationContext.getBean("messageServ", Message.class);
        message.setId(1111);
        message.setMessage("test1");
        assertSame(message.getId(), 1111);
        assertSame(message.getMessage(), "test1");
    }
}
