package com.gmail.derevets.artem.web.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.derevets.artem.web.dto.cassandra.UserCassandra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService extends BaseService<UserCassandra> {

    void saveFromJsonNode(JsonNode user, ObjectMapper objectMapper) throws IOException;

    Optional<UserCassandra> get(UUID id);

    List<UserCassandra> getAllByIds(List<UUID> uuidList);
}
