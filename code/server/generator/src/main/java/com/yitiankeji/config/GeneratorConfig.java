package com.yitiankeji.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "generator")
public class GeneratorConfig {

    private String basepackage;
    private String author;
    private String module;
    private List<String> tables;
    private List<String> prefix;
}
