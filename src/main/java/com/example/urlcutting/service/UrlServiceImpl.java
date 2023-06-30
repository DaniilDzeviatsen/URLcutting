package com.example.urlcutting.service;


import com.example.urlcutting.configs.BlackListProperties;
import com.example.urlcutting.models.Link;
import com.example.urlcutting.repository.UrlJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UrlServiceImpl implements UrlService {
    UrlJdbcRepository urlJdbcRepository;
    BlackListProperties blackListProperties;


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Optional<Link> findFullUrlByShort(long id) {
        if (isUrlLegitimate(urlJdbcRepository.findById(id).get().getInitialUrl())) {
            return urlJdbcRepository.findById(id);
        } else return Optional.empty();
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
}
