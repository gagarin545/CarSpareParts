package ru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cars {
    public static void main(String[] args) {
        SpringApplication.run(Cars.class, args).getBeanFactory();
    }
}
