package com.example.ecommerce.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnection {
    private static MongoConnection instance;
    private final MongoClient mongoClient;

    private MongoConnection(String mongoUri) {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoUri))
                .applyToConnectionPoolSettings(builder -> builder.maxSize(50))
                .build();
        mongoClient = MongoClients.create(settings);
    }

    public static MongoConnection getInstance(String mongoUri) {
        if (instance == null) {
            instance = new MongoConnection(mongoUri);
        }
        return instance;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}