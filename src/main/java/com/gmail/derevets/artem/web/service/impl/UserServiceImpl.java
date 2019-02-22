package com.gmail.derevets.artem.web.service.impl;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.derevets.artem.web.dto.cassandra.User;
import com.gmail.derevets.artem.web.repository.cassandra.UserCassandraRepository;
import com.gmail.derevets.artem.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCassandraRepository userCassandraRepository;

    @Override
    public void save(User userCassandra) {
        userCassandraRepository.insert(userCassandra);
    }

    @Override
    public User get(User userCassandra) {
        return null;
    }

    @Override
    public void saveFromJsonNode(JsonNode user, ObjectMapper mapper) throws IOException {
        User userCassandra = mapper.treeToValue(user, User.class);
        log.info("UserCassandra {}", userCassandra);
        JsonNode externalId = user.get("id");
        userCassandra.setExternalId(UUID.fromString(externalId.asText()));
        userCassandra.setId(UUIDs.timeBased());
        userCassandraRepository.save(userCassandra);
    }

    @Override
    public Optional<User> get(UUID id) {
        return userCassandraRepository.findById(id);
    }

    @Override
    public List<User> getAllByIds(List<UUID> uuidList) {
        return userCassandraRepository.findAllById(uuidList);
    }


}
