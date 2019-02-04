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
    public Queue twitterSaveQueue() {
        return new Queue("user-save-mongo");
    }

    @Bean
    public TopicExchange twitterSaveTopic() {
        return new TopicExchange("UserTopic");
    }

    @Bean
    public Binding twitterSaveTweetBinding() {
        return BindingBuilder.bind(twitterSaveQueue()).to(twitterSaveTopic()).with("user-save");
    }


}
