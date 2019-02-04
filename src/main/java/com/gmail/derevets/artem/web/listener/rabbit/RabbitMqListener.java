package com.gmail.derevets.artem.web.listener.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@EnableRabbit
public class RabbitMqListener {


    @RabbitListener(queues = "twiter-save-mongo")
    public void subscribeWorkerOne() throws InterruptedException {

    }
}
