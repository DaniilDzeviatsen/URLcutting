package com.example.urlcutting.service;


import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

public class UrlServiceImpl implements UrlService{
    JdbcTemplateAutoConfiguration jdbcTemplateAutoConfiguration;

    public UrlServiceImpl(JdbcTemplateAutoConfiguration jdbcTemplateAutoConfiguration) {
        this.jdbcTemplateAutoConfiguration = jdbcTemplateAutoConfiguration;
    }
}
