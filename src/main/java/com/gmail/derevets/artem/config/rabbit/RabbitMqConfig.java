package com.gmail.derevets.artem.config.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class RabbitMqConfig {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public RabbitAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue userSaveCassandraQueue() {
        return new Queue("user-save-cassandra");
    }

    @Bean
    public Queue userSaveElasticQueue() {
            return new Queue("user-save-elastic");
    }

    @Bean
    public TopicExchange twitterSaveTopic() {
        return new TopicExchange("UserTopic");
    }

    @Bean
    public TopicExchange userSaveTopicExchange() {
        return new TopicExchange("UserTopic");
    }

    @Bean
    public Binding userSaveCassandraBinding() {
        return BindingBuilder.bind(userSaveCassandraQueue()).to(twitterSaveTopic()).with("user-save");
    }

    @Bean
    public Binding userSaveElasticBinding() {
        return BindingBuilder.bind(userSaveElasticQueue()).to(twitterSaveTopic()).with("user-save");
    }
}
