package com.example.urlcutting;

import com.example.urlcutting.models.Link;
import com.example.urlcutting.repository.UrlJdbcRepository;
import com.example.urlcutting.service.UrlService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

import java.net.URI;
import java.util.Optional;

@SpringBootApplication
@ConfigurationPropertiesScan
public class URLcuttingApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(URLcuttingApplication.class, args);
       /* UrlJdbcRepository urlJdbcRepository = context.getBean(UrlJdbcRepository.class);
        UrlService urlService=context.getBean(UrlService.class);
        Optional<Link> link=urlService.findFullUrlByShort(3);
        System.out.println(link.get().getInitialUrl().getScheme());
        System.out.println(link.get().getInitialUrl().getHost());*/

    }
}
