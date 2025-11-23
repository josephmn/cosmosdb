package com.azure.cosmosdb.web;

import com.azure.cosmosdb.entity.Person;
import com.azure.cosmosdb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> create(@RequestBody Person p) { return service.save(p); }

    @GetMapping("/{id}")
    public Mono<Person> getById(@PathVariable String id) { return service.findById(id); }

    @GetMapping
    public Flux<Person> all() { return service.findAll(); }

    @GetMapping("/by-country/{country}")
    public Flux<Person> byCountry(@PathVariable String country) { return service.findByCountry(country); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) { return service.deleteById(id); }
}
