package com.vasidzius.learnmongo.mflix;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class CitibikesApplicationContextConfig extends AbstractMongoClientConfiguration {
  @Override
  public MongoClient mongoClient() {
    return MongoClients.create("mongodb://analytics-student:analytics-password@cluster0-shard-00-00-jxeqq.mongodb.net:27017,cluster0-shard-00-01-jxeqq.mongodb.net:27017,cluster0-shard-00-02-jxeqq.mongodb.net:27017/?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
  }

  @Override
  protected String getDatabaseName() {
    return "citibike";
  }
}
