package com.azure.cosmosdb.web;

import com.azure.cosmosdb.service.ContingencyMessageService;
import com.azure.cosmosdb.web.dto.MessageRequest;
import com.azure.cosmosdb.web.dto.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * ContingencyMessageController.
 * This class handles HTTP requests related to contingency messages.
 * It provides endpoints to retrieve all contingency messages,
 * retrieve a contingency message by ID, and create a new contingency message.
 *
 * @author Joseph Magallanes
 * @since 2025-12-16
 */
@RestController
@RequestMapping("/api/v1/contingency-messages")
@RequiredArgsConstructor
public class ContingencyMessageController {

    private final ContingencyMessageService service;

    @GetMapping
    public Mono<ResponseEntity<Flux<MessageResponse>>> getAllContingencyMessages() {
        return Mono.just(ResponseEntity.ok(this.service.getAllContingencyMessages()))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MessageResponse>> getContingencyMessageById(
        @PathVariable("id") String id
    ) {
        return this.service.getContingencyMessageById(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<MessageResponse>> createContingencyMessage(
        @RequestBody Mono<MessageRequest> message
    ) {
        return message.flatMap(dto ->
            this.service.createContingencyMessage(dto)
                .map(responseDto -> ResponseEntity
                    .created(URI.create("/api/v1/contingency-messages/"))
                    .body(responseDto))
                .defaultIfEmpty(ResponseEntity.notFound().build())
        );
    }
}
