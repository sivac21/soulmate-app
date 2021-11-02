package com.stackroute.soulmateservice.service;

import com.stackroute.soulmateservice.model.Profile;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author Siva
 * @Date 10/29/2021 1:02 PM
 */
@Service
public class ProfileMessageProducer {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ProfileMessageProducer(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void sendMessageToRabbitMq(Profile profile)
    {
        rabbitTemplate.convertAndSend(exchange,routingkey, profile);
    }
}
