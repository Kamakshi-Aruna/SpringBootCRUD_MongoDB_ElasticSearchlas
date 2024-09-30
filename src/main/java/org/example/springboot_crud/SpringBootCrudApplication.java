package org.example.springboot_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages ="org.example.springboot_crud.repository.mongo")
@EnableElasticsearchRepositories(basePackages = "org.example.springboot_crud.repository.elastic")
public class SpringBootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudApplication.class, args);
    }

}
