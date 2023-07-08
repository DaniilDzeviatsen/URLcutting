package com.example.urlcutting.service;


import com.example.urlcutting.configs.BlackListProperties;
import com.example.urlcutting.exception.BusinessException;
import com.example.urlcutting.models.Link;
import com.example.urlcutting.repository.UrlJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.net.URISyntaxException;

@AllArgsConstructor
@Service
public class UrlServiceImpl implements UrlService {
    UrlJdbcRepository urlJdbcRepository;
    BlackListProperties blackListProperties;


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Link findFullUrlByShort(long id) {
        return urlJdbcRepository.findById(id).
                orElseThrow(IllegalArgumentException::new);
    }

    private boolean isUrlLegitimate(URI fullUrl) {
        if (fullUrl.getScheme().equals("http") || fullUrl.getScheme().equals("https")) {
            for (String black : blackListProperties.getBlackList()) {
                if (fullUrl.getHost().equals(black)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    @Transactional
    public Link addLink(URI fullUrl) {

        if (!isUrlLegitimate(fullUrl)) {
            throw new BusinessException("Incorrect or blacklisted URL has been entered");
        }
        return urlJdbcRepository.addNewLink(fullUrl);

    }
}
