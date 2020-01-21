package com.itea.task.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorldBpp implements BeanPostProcessor {

    private static Logger logger = Logger.getLogger(HelloWorldBpp.class);

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessAfterInitialisation in HelloWorld class");
        return o;
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String beanName) throws BeansException {
        logger.info("PostProcessorBeforeInitialization in HelloWorld class");
        return o;
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("PreDestroy in HelloWorld class");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("PostConstructor in HelloWorld class");
    }
}
