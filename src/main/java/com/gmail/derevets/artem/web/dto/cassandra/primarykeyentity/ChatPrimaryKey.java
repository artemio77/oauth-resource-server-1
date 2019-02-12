package com.gmail.derevets.artem.web.dto.cassandra.primarykeyentity;

import com.gmail.derevets.artem.web.dto.cassandra.type.ChatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Component
@Builder
@PrimaryKeyClass
@AllArgsConstructor
@NoArgsConstructor
public class ChatPrimaryKey implements Serializable {

    @PrimaryKeyColumn(name = "id", type= PrimaryKeyType.PARTITIONED)
    private UUID id;
    @PrimaryKeyColumn(name = "chat_type")
    private ChatType chatType;

    @PrimaryKeyColumn(name = "participant")
    private List<UUID> participant;


}
