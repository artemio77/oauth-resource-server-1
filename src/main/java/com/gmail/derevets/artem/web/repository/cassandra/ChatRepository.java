package com.gmail.derevets.artem.web.repository.cassandra;

import com.gmail.derevets.artem.web.dto.cassandra.Chat;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatRepository extends CassandraRepository<Chat, UUID> {
}
