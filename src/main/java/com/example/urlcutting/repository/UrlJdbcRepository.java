package com.example.urlcutting.repository;

import com.example.urlcutting.models.Link;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public interface UrlJdbcRepository {

   Optional<Link> findById(long id);

    Optional<Link> getShortByFullUrl(String fullUrl);


    Link addNewLink(URI initialUrl);
}
