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
public class RandomValue implements BeanPostProcessor {

    private static Logger logger = Logger.getLogger(RandomValue.class);
    private int min;
    private int max;
    private int value;

    public int random(){
        return value = (int)(min + Math.random() * (max - min));
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessBeforeInitialization in RandomValue class");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("PostProcessAfterInitialization in RandomValue class");
        return null;
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("PreDestroy in RandomValue class");
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("PostConstruct in RandomValue class");
    }
}
