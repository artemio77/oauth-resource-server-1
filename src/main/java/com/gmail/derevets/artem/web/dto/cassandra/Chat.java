package com.gmail.derevets.artem.web.dto.cassandra;

import com.gmail.derevets.artem.web.dto.cassandra.primarykeyentity.ChatPrimaryKey;
import com.gmail.derevets.artem.web.dto.cassandra.type.ChatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Data
@Table
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Chat extends BaseCassandraEntity<UUID> {

    @PrimaryKey
    private ChatPrimaryKey key;

    private String description;
}
