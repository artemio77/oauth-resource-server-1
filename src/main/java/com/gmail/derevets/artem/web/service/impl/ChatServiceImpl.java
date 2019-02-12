package com.gmail.derevets.artem.web.service.impl;

import com.gmail.derevets.artem.web.dto.cassandra.Chat;
import com.gmail.derevets.artem.web.dto.cassandra.UserCassandra;
import com.gmail.derevets.artem.web.repository.cassandra.ChatRepository;
import com.gmail.derevets.artem.web.service.ChatService;
import com.gmail.derevets.artem.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserService userService;

    @Override
    public void save(Chat chat) {
        if (validateChatParameters(chat)) {
            log.info("Chat save {}", chat);
            chatRepository.save(chat);
        }
    }

    @Override
    public Chat get(Chat chat) {
        Optional<Chat> chatOptional = chatRepository.findById(chat.getKey().getId());
        return chatOptional.get();
    }


    private Boolean validateChatParameters(Chat chat) {
        List<UUID> participantList = chat.getKey().getParticipant();
        List<UUID> userCassandraList = userService.getAllByIds(participantList).stream()
                .map(userCassandra -> userCassandra.getKey().getId())
                .collect(Collectors.toList());
        return participantList.containsAll(userCassandraList);
    }
}
