package com.example.config;


import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.database}")
    private String databaseName;
    @Value("${spring.data.mongodb.host}")
    private String host;

    @Bean
    public MongoClient mongo() {
        return new MongoClient(host);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), databaseName);
    }

}
