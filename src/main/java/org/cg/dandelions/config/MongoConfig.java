package org.cg.dandelions.config;

import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Component
public class MongoConfig {

	public MongoClient client;
	public MongoDatabase database;

	public MongoConfig() {
		client = new MongoClient("localhost");
		database = client.getDatabase("dandelion");
	}

}
