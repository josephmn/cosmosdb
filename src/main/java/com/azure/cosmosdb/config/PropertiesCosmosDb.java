package com.azure.cosmosdb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "azure.cosmos")
@Getter
@Setter
public class PropertiesCosmosDb {
    private String uri;
    private String key;
    private String database;
}
