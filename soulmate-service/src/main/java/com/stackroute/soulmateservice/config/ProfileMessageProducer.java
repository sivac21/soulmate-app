package com.stackroute.soulmateservice.config;

import com.stackroute.soulmateservice.rabbitmq.model.ProfileDTO;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Siva
 * @Date 10/29/2021 1:02 PM
 */
@Component
public class ProfileMessageProducer {
    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    @Autowired
    public ProfileMessageProducer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void sendMessageToRabbitMq(ProfileDTO profileDTO)
    {
        rabbitTemplate.convertAndSend(directExchange.getName(), "user_routing",profileDTO);
    }
}
