package com.gmail.derevets.artem.web.dto.cassandra;

import com.datastax.driver.core.DataType;
import com.gmail.derevets.artem.web.dto.cassandra.primarykeyentity.UserCassandraPrimaryKey;
import com.gmail.derevets.artem.web.dto.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Data
@Table("user")
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCassandra extends BaseCassandraEntity<UserCassandraPrimaryKey> implements Serializable {

    @PrimaryKey
    private UserCassandraPrimaryKey key;

    private String firstName;

    private String lastName;

    private Role role;

    private Boolean isAccountNonLocked;

    private Boolean isAccountNonExpired;

    private Boolean isCredentialsNonLocked;

    private Boolean isEnabled;

    private Long verificationCode;

}
