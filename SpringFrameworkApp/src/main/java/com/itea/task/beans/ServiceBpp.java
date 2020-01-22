package com.itea.task.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ServiceBpp implements BeanPostProcessor {

    private static Logger logger = Logger.getLogger(ServiceBpp.class);

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
}
