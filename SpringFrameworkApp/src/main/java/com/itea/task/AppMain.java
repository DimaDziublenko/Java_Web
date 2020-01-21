package com.itea.task;

import com.itea.task.beans.HelloWorld;
import com.itea.task.beans.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("message.xml");
        Message message = ac.getBean("messageServ", Message.class);
        message.setId(1001);
        message.setMessage("Hello world!");
        System.out.println(message.toString());
        Message message1 = ac.getBean("messageServ", Message.class);
        System.out.println(message1.toString());
        ((AbstractApplicationContext) ac).close();
        ac = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = ac.getBean("helloWorld", HelloWorld.class);
        helloWorld.setMessage("Hello world");
        System.out.println(helloWorld.getMessage());
    }
}
