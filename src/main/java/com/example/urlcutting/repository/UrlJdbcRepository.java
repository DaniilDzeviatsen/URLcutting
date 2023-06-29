package com.example.urlcutting.repository;

import com.example.urlcutting.models.Link;

import java.util.List;
import java.util.Optional;

public interface UrlJdbcRepository {

   Optional<Link> findById(long id);

    void addNewLink (String initialUrl);
    List<Link> findAll();

}
