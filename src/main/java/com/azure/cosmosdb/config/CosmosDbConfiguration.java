package com.azure.cosmosdb.config;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CosmosDbConfiguration extends AbstractCosmosConfiguration {

    private static final String DATABASE_NAME = "cosmosdb";

    @Bean
    public CosmosAsyncClient cosmosAsyncClient() {
        return new CosmosClientBuilder()
            .endpoint("https://localhost:8081")
            .key("C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw==")
            .consistencyLevel(ConsistencyLevel.EVENTUAL)
            .connectionSharingAcrossClientsEnabled(true)
            // Elige uno: directMode() o gatewayMode(). Aquí uso directMode().
            .directMode()
            // IMPORTANTE: forzar que la respuesta de escritura incluya el documento
            .contentResponseOnWriteEnabled(true)
            .buildAsyncClient();
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }
}
