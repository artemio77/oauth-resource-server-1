package com.gmail.derevets.artem.web.controller;

import com.gmail.derevets.artem.web.dto.cassandra.Chat;
import com.gmail.derevets.artem.web.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("/chatManagement/")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public @ResponseBody
    Chat createChat(@RequestBody Chat chat) {
        chatService.save(chat);
        return chat;
    }

}
