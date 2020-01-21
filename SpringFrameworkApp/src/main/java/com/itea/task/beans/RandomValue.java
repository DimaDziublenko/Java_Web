package com.itea.task.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
@ToString
public class RandomValue {

    private int min;
    private int max;
    private int value;

    public int random() {
        return value = (int) (min + Math.random() * (max - min));
    }

    @PostConstruct
    public void init(){
        System.out.println("Bean is going through init.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean will destroy now.");
    }
}
