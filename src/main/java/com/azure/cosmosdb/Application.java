package com.azure.cosmosdb;

import com.azure.spring.cloud.autoconfigure.implementation.context.AzureTokenCredentialAutoConfiguration;
import com.azure.spring.data.cosmos.repository.config.EnableReactiveCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = AzureTokenCredentialAutoConfiguration.class)
@EnableReactiveCosmosRepositories(basePackages = "com.azure.cosmosdb.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
