package com.example.urlcutting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class URLcuttingApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(URLcuttingApplication.class, args);


    }
}
