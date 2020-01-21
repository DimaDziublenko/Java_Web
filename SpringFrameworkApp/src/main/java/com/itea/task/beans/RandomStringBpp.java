package com.itea.task.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class RandomStringBpp implements BeanPostProcessor {

    private static Logger logger = Logger.getLogger(RandomString.class);

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessBeforeInitialization in RandomString class");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessAfterInitialization in RandomString class");
        return o;
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("PreDestroy in RandomString class");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("PostConstruct in RandomString class");
    }
}
