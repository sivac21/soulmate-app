//package com.stackroute.userservice.service;
//
//import com.stackroute.userservice.model.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * @Author Siva
// * @Date 10/29/2021 1:02 PM
// */
//@Component
//public class MessageConsumer implements RabbitListenerConfigurer {
//    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
//
//    @Value("${spring.rabbitmq.exchange}")
//    private String exchange;
//
//    @Value("${spring.rabbitmq.routingkey}")
//    private String routingkey;
//
//    @RabbitListener(queues = "${spring.rabbitmq.queue}")
//    public void receiveMessageToRabbitMq(User user)
//    {
//        logger.info("Received User" + user);
//    }
//
//    @Override
//    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar){
//
//    }
//}
