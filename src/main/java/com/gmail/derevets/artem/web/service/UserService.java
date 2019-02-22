package com.gmail.derevets.artem.web.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.derevets.artem.web.dto.cassandra.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService extends BaseService<User> {

    void saveFromJsonNode(JsonNode user, ObjectMapper objectMapper) throws IOException;

    Optional<User> get(UUID id);

    List<User> getAllByIds(List<UUID> uuidList);
}
