package com.azure.cosmosdb.repository;

import com.azure.cosmosdb.entity.Person;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository extends ReactiveCosmosRepository<Person, String> {
    Flux<Person> findByCountry(String country);
}
