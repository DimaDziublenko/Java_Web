package com.itea.task.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class User {

    private String name;
    private String password;
}
