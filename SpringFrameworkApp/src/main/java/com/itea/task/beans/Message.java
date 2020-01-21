package com.itea.task.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
@ToString
public class Message implements BeanPostProcessor {

    private static Logger logger = Logger.getLogger(Message.class);
    private int id;
    private String message;

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessBeforeInitialization in Message class");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessAfterInitialization in Message class");
        return null;
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("PreDestroy in Message class");
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("PostConstruct in Message class");
    }
}
