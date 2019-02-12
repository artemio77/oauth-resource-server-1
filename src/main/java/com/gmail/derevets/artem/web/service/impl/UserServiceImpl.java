package com.gmail.derevets.artem.web.service.impl;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.derevets.artem.web.dto.cassandra.UserCassandra;
import com.gmail.derevets.artem.web.dto.cassandra.primarykeyentity.UserCassandraPrimaryKey;
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
    public void save(UserCassandra userCassandra) {

        userCassandraRepository.insert(userCassandra);
    }

    @Override
    public UserCassandra get(UserCassandra userCassandra) {
        return null;
    }

    @Override
    public void saveFromJsonNode(JsonNode user, ObjectMapper mapper) throws IOException {
        UserCassandra userCassandra = mapper.treeToValue(user, UserCassandra.class);
        log.info("UserCassandra {}", userCassandra);
        JsonNode externalId = user.get("id");
        userCassandra.setKey(UserCassandraPrimaryKey.builder()
                .email(String.valueOf(user.get("email")))
                .externalId(UUID.fromString(externalId.asText()))
                .id(UUIDs.timeBased())
                .build());
        userCassandraRepository.save(userCassandra);
    }

    @Override
    public Optional<UserCassandra> get(UUID id) {
        return userCassandraRepository.findById(id);
    }

    @Override
    public List<UserCassandra> getAllByIds(List<UUID> uuidList) {
        return userCassandraRepository.findAllById(uuidList);
    }


}
