package com.azure.cosmosdb.service.impl;

import com.azure.cosmosdb.repository.ContingencyMessageRepository;
import com.azure.cosmosdb.service.ContingencyMessageService;
import com.azure.cosmosdb.util.ContingencyMessageMapper;
import com.azure.cosmosdb.web.dto.MessageRequest;
import com.azure.cosmosdb.web.dto.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContingencyMessageServiceImpl implements ContingencyMessageService {

    private final ContingencyMessageRepository repository;
    private final ContingencyMessageMapper mapper;

    @Override
    public Flux<MessageResponse> getAllContingencyMessages() {
        log.info("Start execute method getAllContingencyMessages");
        return this.repository.findAll()
            .map(this.mapper::contingencyMessageToResponse)
            .doOnTerminate(() -> log.info("Finished execute method getAllContingencyMessages"));
    }

    @Override
    public Mono<MessageResponse> getContingencyMessageById(String id) {
        log.info("Start execute method getContingencyMessageById");
        return this.repository.findById(id)
            .map(this.mapper::contingencyMessageToResponse)
            .doOnTerminate(() -> log.info("Finished execute method getContingencyMessageById"));
    }

    @Override
    public Mono<MessageResponse> createContingencyMessage(MessageRequest message) {
        log.info("Start execute method createContingencyMessage");

        var entity = this.mapper.requestToContingencyMessage(message);

        entity.setPk("CONTINGENCY");

        return this.repository.save(entity)
                    .map(this.mapper::contingencyMessageToResponse)
            .doOnTerminate(() -> log.info("Finished execute method createContingencyMessage"));
    }
}
