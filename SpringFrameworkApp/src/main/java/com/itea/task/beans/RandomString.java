package com.itea.task.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
@ToString
public class RandomString {

    private int size;
    private String value;

    public String random() {
        char symbol;
        for (int i = 0; i < size; i++) {
            symbol = (char) (48 + Math.random() * 47);
            value += symbol;
        }
        return value;
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
