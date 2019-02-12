package com.gmail.derevets.artem.web.listener.rabbit;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.derevets.artem.web.dto.cassandra.UserCassandra;
import com.gmail.derevets.artem.web.dto.cassandra.primarykeyentity.UserCassandraPrimaryKey;
import com.gmail.derevets.artem.web.service.UserService;
import com.gmail.derevets.artem.web.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;


@Slf4j
@Service
@EnableRabbit
public class RabbitMqUserListener {

    @Autowired
    private UserService userService;

    @RabbitListener(queues = "user-save-cassandra")
    public void subscribeWorkerOne(String userExternal) throws IOException {
        log.info("User {}", userExternal);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode userJson = mapper.readTree(userExternal);
        userService.saveFromJsonNode(userJson, mapper);
    }
}
