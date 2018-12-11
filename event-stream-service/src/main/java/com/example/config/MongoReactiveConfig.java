package com.example.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@EnableReactiveMongoRepositories
public class MongoReactiveConfig extends AbstractReactiveMongoConfiguration {
    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient() , getDatabaseName());
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
}