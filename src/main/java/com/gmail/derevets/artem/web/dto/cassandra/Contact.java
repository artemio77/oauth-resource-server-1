package com.gmail.derevets.artem.web.dto.cassandra;

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
public class Contact extends BaseCassandraEntity<UUID> {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private UUID id;

    @PrimaryKeyColumn
    private List<UUID> participant;

    private boolean approved;
}
