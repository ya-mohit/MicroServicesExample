package com.mohit.ms.microServicesExample.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup sourceLookup = new JndiDataSourceLookup();
		sourceLookup.setResourceRef(true);
		DataSource dataSource = sourceLookup.getDataSource("MySqlSB");
		return dataSource;
	}
	
	@Bean
	public MongoClient mongoClient() throws NamingException {
		Context context = (Context) new InitialContext().lookup("java:comp/env");
		String uri = (String) context.lookup("MONGODB_URI");
		ConnectionString connectionString = new ConnectionString(uri);
		MongoClient client = MongoClients.create(connectionString);
		return client;
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoClient mongoClient) {
		return new MongoTemplate(mongoClient, "springBoot"); // Specify your database name here
	}
	
	@Bean
	public ModelMapper mM(){
		return new ModelMapper();
	}
}
