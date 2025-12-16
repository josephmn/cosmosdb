package com.azure.cosmosdb.config;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CosmosDbConfiguration extends AbstractCosmosConfiguration {

    private final PropertiesCosmosDb propertiesCosmosDb;

    @Bean
    public CosmosAsyncClient cosmosAsyncClient() {
        return new CosmosClientBuilder()
            .endpoint(this.propertiesCosmosDb.getUri())
            .key(this.propertiesCosmosDb.getKey())
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
        return this.propertiesCosmosDb.getDatabase();
    }
}
