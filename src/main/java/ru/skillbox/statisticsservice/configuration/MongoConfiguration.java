package ru.skillbox.statisticsservice.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    @Bean
    public MongoClient mongoClient() {
        System.setProperty("javax.net.ssl.keyStore", "src/main/resources/keystore/custom_keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .applyToSslSettings(builder -> builder.enabled(true).invalidHostNameAllowed(true))
                .build();

        return MongoClients.create(settings);
    }
}
