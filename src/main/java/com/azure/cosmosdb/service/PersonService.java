package com.azure.cosmosdb.service;

import com.azure.cosmosdb.entity.Person;
import com.azure.cosmosdb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repo;

    public Mono<Person> save(Person p) { return repo.save(p); }
    public Mono<Person> findById(String id) { return repo.findById(id); }
    public Flux<Person> findAll() { return repo.findAll(); }
    public Flux<Person> findByCountry(String c) { return repo.findByCountry(c); }
    public Mono<Void> deleteById(String id) { return repo.deleteById(id); }
}
