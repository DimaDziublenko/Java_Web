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
public class RandomString implements BeanPostProcessor {

    private static Logger logger = Logger.getLogger(RandomString.class);
    private int size;
    private String value;

    public String random(){
        char symbol;
        for(int i = 0; i < size; i++){
            symbol = (char)(48 + Math.random() * 47);
            value += symbol;
        }
        return value;
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessBeforeInitialization in RandomString class");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessAfterInitialization in RandomString class");
        return null;
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("PreDestroy in RandomString class");
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("PostConstruct in RandomString class");
    }
}
