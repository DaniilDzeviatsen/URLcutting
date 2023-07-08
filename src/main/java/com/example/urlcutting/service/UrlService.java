package com.example.urlcutting.service;

import com.example.urlcutting.models.Link;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;

public interface UrlService {


    @Transactional
    Link findFullUrlByShort(long id);

    @Transactional
    Link addLink(URI fullUrl);
}
