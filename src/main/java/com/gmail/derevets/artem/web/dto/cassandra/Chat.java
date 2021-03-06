package com.gmail.derevets.artem.web.dto.cassandra;

import com.gmail.derevets.artem.web.dto.cassandra.type.ChatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
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

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id;
    @PrimaryKeyColumn(name = "chat_type")
    private ChatType chatType;

    @PrimaryKeyColumn(name = "participant")
    private List<UUID> participant;

    private String description;
}
