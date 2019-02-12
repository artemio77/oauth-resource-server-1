package com.gmail.derevets.artem.web.controller;

import com.gmail.derevets.artem.web.dto.cassandra.Message;
import groovy.util.logging.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/messageManagement/")
public class MessageController {

    @MessageMapping("/chat/{sendToId}/{sendFrom}/{chatId}")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }


}
