package com.example.urlcutting.service;

import com.example.urlcutting.models.Link;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UrlService {



    @Transactional
    Optional<Link> findFullUrlByShort(long id);
}
