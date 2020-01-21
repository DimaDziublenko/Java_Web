package com.itea.task.beans;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
public class HelloWorld implements BeanPostProcessor {

    private static Logger logger = Logger.getLogger(HelloWorld.class);
    private String message;

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessAfterInitialisation in HelloWorld class");
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("PostProcessorBeforeInitialization in HelloWorld class");
        return null;
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
