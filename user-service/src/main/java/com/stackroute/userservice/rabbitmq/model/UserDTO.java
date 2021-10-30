package com.stackroute.userservice.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author Siva
 * @Date 10/29/2021 8:28 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String email;
    private String password;
}
