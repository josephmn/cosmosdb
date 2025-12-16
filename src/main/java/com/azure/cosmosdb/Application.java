package com.azure.cosmosdb;

import com.azure.spring.cloud.autoconfigure.implementation.context.AzureTokenCredentialAutoConfiguration;
import com.azure.spring.data.cosmos.repository.config.EnableReactiveCosmosRepositories;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = AzureTokenCredentialAutoConfiguration.class)
@EnableReactiveCosmosRepositories(basePackages = "com.azure.cosmosdb.repository")
public class Application {

	public static void main(String[] args) {
        final Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(Application.class, args);
	}

}
