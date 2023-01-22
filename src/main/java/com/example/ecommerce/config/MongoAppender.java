package com.example.ecommerce.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MongoAppender extends UnsynchronizedAppenderBase<ILoggingEvent>{
    private final Logger log = LoggerFactory.getLogger(MongoAppender.class);
    private String mongoUri;
    private String database;
    private String collection;
    private MongoClient mongoClient;
    private MongoCollection<Document> mongoCollection;


    @Override
    protected void append(ILoggingEvent event) {
        if (!started) {
            return;
        }
        Document doc = new Document("timestamp", event.getTimeStamp())
                .append("level", event.getLevel().toString())
                .append("thread", event.getThreadName())
                .append("logger", event.getLoggerName())
                .append("message", event.getFormattedMessage());
        mongoCollection.insertOne(doc);
    }

    @Override
    public void start() {
        try {
            MongoConnection mongoConnection = MongoConnection.getInstance(mongoUri);
            mongoClient = mongoConnection.getMongoClient();
            MongoDatabase mongoDatabase = mongoConnection.getMongoClient().getDatabase(database);
            mongoCollection = mongoDatabase.getCollection(collection);
            super.start();
        } catch (Exception e) {
            log.error("Error connecting to MongoDB: " + e.getMessage(), e);
        }
    }

    @Override
    public void stop() {
        try {
//            mongoClient.close();
            super.stop();
        } catch (Exception e) {
            log.error("Error closing MongoDB connection: " + e.getMessage(), e);
        }
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public void setMongoUri(String mongoUri) {
        this.mongoUri = mongoUri;
    }
}