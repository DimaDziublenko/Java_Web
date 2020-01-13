package com.itea.tasks.injectRandomValue;

import java.lang.reflect.Field;

import static java.lang.Math.abs;
import static java.lang.Math.random;

public class InjectRandomValueClass {

    public void randomValue(Object object) throws IllegalAccessException {
        int value;
        Class<?> objectClass = object.getClass();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(InjectRandomValue.class)) {
                int min = field.getAnnotation(InjectRandomValue.class).min();
                int max = field.getAnnotation(InjectRandomValue.class).max();
                if (min > 0) {
                    value = (int) (min + random() * (max - min));
                }
                else {
                    value = (int) (min + random() * (abs(min) + max));
                }
                if (value != 0 && !field.isAnnotationPresent(InjectRandomValue.class)) {
                    if (field.getType() == String.class) {
                        field.set(object.getClass(), "unknown");
                    }
                    if (field.getType() == char.class) {
                        field.setChar(object.getClass(), (char) value);
                    }
                    if (field.getType() == boolean.class) {
                        field.set(object.getClass(), random() < 0.5);
                    }
                    else {
                        field.setInt(object.getClass(), value);
                    }
                    value = 0;
                }
            }
        }
    }
}
