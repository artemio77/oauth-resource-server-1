package com.gmail.derevets.artem.web.dto.cassandra;

import com.gmail.derevets.artem.web.dto.cassandra.type.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;


import java.util.UUID;

@Data
@Table
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Message extends BaseCassandraEntity<UUID> {

    @PrimaryKey
    private UUID id;

    private MessageType messageType;

    private String text;

    private Chat chat;


}
