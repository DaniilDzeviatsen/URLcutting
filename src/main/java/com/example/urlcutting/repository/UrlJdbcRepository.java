package com.example.urlcutting.repository;

public interface UrlJdbcRepository {

    boolean ifShortenedUrlExists(String initialUrl);

    void addNewLink (String initialUrl, String shortUrl);

}
