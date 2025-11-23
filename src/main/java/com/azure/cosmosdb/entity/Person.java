package com.azure.cosmosdb.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@Container(containerName = "persons")
public class Person implements Serializable {
    @Id
    private String id;
    private String name;
    @PartitionKey
    private String country;
}
