package com.example.urlcutting.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Value
public class Link {
    String initialUrl;
    long id;

}
