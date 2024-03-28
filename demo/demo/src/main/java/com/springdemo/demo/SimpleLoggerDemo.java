package com.springdemo.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:log4j2.properties")
public class SimpleLoggerDemo {
    public static void main(String[] args) {
        SpringApplication.run(SimpleLoggerDemo.class, args);
    }
}
