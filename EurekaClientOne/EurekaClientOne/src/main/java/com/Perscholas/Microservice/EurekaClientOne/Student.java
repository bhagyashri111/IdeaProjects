package com.Perscholas.Microservice.EurekaClientOne;

import lombok.Getter;
import lombok.Setter;

public class Student {
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String className;
    public Student(String name, String className) {
        super();
        this.name = name;
        this.className = className;
    }
    public Student() {
    }

}

