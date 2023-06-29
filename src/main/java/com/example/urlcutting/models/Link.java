package com.example.urlcutting.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.net.URI;
import java.net.URL;

@Value
public class Link {
    URI initialUrl;
    long id;

}
