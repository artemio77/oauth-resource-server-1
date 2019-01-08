package com.gmail.derevets.artem.web.rabbit.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@EnableRabbit
@Component
@Slf4j
public class RabbitMqListener {

    @RabbitListener(queues = "subscribe-queue-one")
    public void subscribeWorkerOne(String message) throws InterruptedException {
        log.info("worker 1 : {}", message);
        Thread.sleep(1000 * new Random().nextInt(20));
    }

    @Bean
    public Queue subscribeQueueOne() {
        return new Queue("subscribe-queue-one");
    }
}
