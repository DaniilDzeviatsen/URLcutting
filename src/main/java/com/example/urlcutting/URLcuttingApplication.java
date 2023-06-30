package com.example.urlcutting;

import com.example.urlcutting.repository.UrlJdbcRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class URLcuttingApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(URLcuttingApplication.class, args);
        UrlJdbcRepository urlJdbcRepository = context.getBean(UrlJdbcRepository.class);
       //urlJdbcRepository.addNewLink("wefwed");
       // System.out.println(urlJdbcRepository.findAll());

    }
}
