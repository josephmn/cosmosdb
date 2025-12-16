package com.azure.cosmosdb.service;

import com.azure.cosmosdb.web.dto.MessageRequest;
import com.azure.cosmosdb.web.dto.MessageResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ContingencyMessageService {
    Flux<MessageResponse> getAllContingencyMessages();
    Mono<MessageResponse> getContingencyMessageById(String id);
    Mono<MessageResponse> createContingencyMessage(MessageRequest message);
}
