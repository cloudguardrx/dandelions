package org.cg.dandelions.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Configuration
@Component
public class MongoConfig {
	
    @Value("${mongo.uri}")
    public String mongoUri;
    
    @Value("${mongo.database}")
    public String mongoDatabase;

	public MongoClient client;
	public MongoDatabase database;

	public MongoConfig() {
	}
	
	@PostConstruct
	public void init() {
		this.client = new MongoClient(new MongoClientURI(mongoUri));
		this.database = client.getDatabase(mongoDatabase);
	}

}
