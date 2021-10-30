package com.stackroute.userservice.config;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.rabbitmq.model.UserDTO;
import com.stackroute.userservice.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Siva
 * @Date 10/29/2021 12:57 PM
 */
public class MessageConsumer {
    private UserService userService;
    @Autowired
    public MessageConsumer(UserService userService)
    {
        this.userService = userService;
    }

    @RabbitListener(queues = "user_queue")
    public void getUserDtoFromRabbitMq(UserDTO userDTO) throws UserAlreadyExistsException
    {
        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userService.saveUser(user);
    }
}
