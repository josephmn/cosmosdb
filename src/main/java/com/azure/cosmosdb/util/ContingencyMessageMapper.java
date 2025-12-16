package com.azure.cosmosdb.util;

import com.azure.cosmosdb.entity.ContingencyMessage;
import com.azure.cosmosdb.web.dto.MessageRequest;
import com.azure.cosmosdb.web.dto.MessageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * UserMapper.
 * This interface defines methods to map between MessageResponse and ContingencyMessage.
 * It uses MapStruct for the mapping implementation.
 *
 * @author Joseph Magallanes
 * @since 2025-12-16
 */
@Mapper(componentModel = "spring")
public interface ContingencyMessageMapper {

    /**
     * Maps a MessageRequest to a ContingencyMessage.
     * @param messageRequest the MessageRequest to map
     * @return the mapped ContingencyMessage
     */
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "message", target = "message"),
        @Mapping(source = "status", target = "status")
    })
    ContingencyMessage requestToContingencyMessage(MessageRequest messageRequest);

    /**
     * Maps a ContingencyMessage to a MessageResponse.
     * @param message the ContingencyMessage to map
     * @return the mapped MessageResponse
     */
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "pk", target = "pk"),
        @Mapping(source = "message", target = "message"),
        @Mapping(source = "status", target = "status")
    })
    MessageResponse contingencyMessageToResponse(ContingencyMessage message);
}
