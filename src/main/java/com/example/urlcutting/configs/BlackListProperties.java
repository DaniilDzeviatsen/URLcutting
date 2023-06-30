package com.example.urlcutting.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.List;

@ConfigurationProperties(prefix = "black")
@Getter
@AllArgsConstructor
@ConfigurationPropertiesScan
public class BlackListProperties {
   private List<String> blackList;
}
