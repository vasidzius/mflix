package com.vasidzius.learnmongo.mflix;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class ApplicationContextConfig extends AbstractMongoClientConfiguration {
  @Override
  public MongoClient mongoClient() {
    return MongoClients.create("mongodb+srv://analytics:analytics-password@mflix-5zwen.mongodb.net/test?retryWrites=true");
  }

  @Override
  protected String getDatabaseName() {
    return "mflix";
  }
}
