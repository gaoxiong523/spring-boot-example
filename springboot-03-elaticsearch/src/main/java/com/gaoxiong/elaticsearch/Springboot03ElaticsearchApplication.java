package com.gaoxiong.elaticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.gaoxiong.elaticsearch.repository")
public class Springboot03ElaticsearchApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(Springboot03ElaticsearchApplication.class, args);
    }
}
