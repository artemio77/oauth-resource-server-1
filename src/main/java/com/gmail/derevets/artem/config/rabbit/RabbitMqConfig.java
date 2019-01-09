package com.gmail.derevets.artem.config.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;


@Slf4j
@Configuration
public class RabbitMqConfig {
    @Value("${rabbitmq.url}")
    private String rabbitMqUrl;

    @Bean
    public ConnectionFactory connectionFactory() throws URISyntaxException {
        URI uri = new URI(rabbitMqUrl);
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(uri);
        if (StringUtils.isNotBlank(uri.getPath()))
            connectionFactory.setVirtualHost(uri.getPath().replace("/", ""));
        connectionFactory.setConnectionTimeout(3000);
        connectionFactory.setRequestedHeartBeat(30);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() throws URISyntaxException {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() throws URISyntaxException {
        return new RabbitTemplate(connectionFactory());
    }
}
