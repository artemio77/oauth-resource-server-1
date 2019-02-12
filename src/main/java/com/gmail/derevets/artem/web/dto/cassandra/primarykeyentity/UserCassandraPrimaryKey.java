package com.gmail.derevets.artem.web.dto.cassandra.primarykeyentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Data
@Component
@Builder
@PrimaryKeyClass
@AllArgsConstructor
@NoArgsConstructor
public class UserCassandraPrimaryKey  implements Serializable {

    @PrimaryKeyColumn(name = "id")
    private UUID id;

    @PrimaryKeyColumn(name = "externalId")
    private UUID externalId;

    @PrimaryKeyColumn(name = "email", type = PrimaryKeyType.PARTITIONED)
    private String email;

}
