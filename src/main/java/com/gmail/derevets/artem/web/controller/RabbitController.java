package com.gmail.derevets.artem.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Slf4j
@RestController
@RequestMapping("/rabbit")
public class RabbitController {



    @Autowired
    private RabbitAdmin admin;
    @Autowired
    private List<Queue> rabbitQueues;


    @RequestMapping("/queue/info")
    @ResponseBody
    public List<String> sendIntoQueue() {
        List<String> list = new ArrayList<>();
        Properties props;
        Integer messageCount;
        for (Queue queue : rabbitQueues) {
            props = admin.getQueueProperties(queue.getName());
            messageCount = Integer.parseInt(props.get("QUEUE_MESSAGE_COUNT").toString());
            log.info(queue.getName() + " has " + messageCount + " messages");
            list.add(queue.getName() + " has " + messageCount + " messages");
        }

        return list;
    }



}


