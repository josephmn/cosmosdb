package com.azure.cosmosdb.repository;

import com.azure.cosmosdb.entity.ContingencyMessage;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import reactor.core.publisher.Mono;

public interface ContingencyMessageRepository extends ReactiveCosmosRepository<ContingencyMessage, String> {
}
