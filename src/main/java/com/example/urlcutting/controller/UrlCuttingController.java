package com.example.urlcutting.controller;

import com.example.urlcutting.models.Link;
import com.example.urlcutting.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UrlCuttingController {


    private final UrlService urlService;

    @GetMapping("/to/{id}")
    public ResponseEntity <?> redirect (@PathVariable long id){
        Link link=urlService.findFullUrlByShort(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(link.getInitialUrl())
                .build();
    }


    @PostMapping("/add-link")
    public ResponseEntity<?> addLink(@RequestParam URI url,
                                     UriComponentsBuilder uriComponentsBuilder){
Link link=urlService.addLink(url);
URI redirectUrl=uriComponentsBuilder
        .path("/")
        .queryParam("id", link.getId())
        .build()
        .toUri();
return ResponseEntity.status(HttpStatus.FOUND)
        .location(redirectUrl)
        .build();
    }
    @GetMapping("/")
    public ModelAndView getHomePage (@RequestParam (required = false) Long id,
                                     UriComponentsBuilder uriComponentsBuilder){
        Link shortenedLink = id==null? null:urlService.findFullUrlByShort(id);
        String baseShortLinkUrl = uriComponentsBuilder
                .path("/to/")
                .build()
                .toUriString();

        Map <String, Object> model =new HashMap<>();
        model.put("shortLink", shortenedLink);
        model.put("baseShortLinkUrl", baseShortLinkUrl);

        return new ModelAndView("main-page", model);
    }

}


