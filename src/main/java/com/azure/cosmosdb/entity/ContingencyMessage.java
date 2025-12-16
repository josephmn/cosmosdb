package com.azure.cosmosdb.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Container(containerName = "contingency-message")
public class ContingencyMessage {

    @Id
    private String id;

    @PartitionKey
    private String pk;

    private String message;
    private Boolean status;
}
