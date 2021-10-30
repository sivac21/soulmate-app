package com.stackroute.soulmateservice.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author Siva
 * @Date 10/29/2021 8:11 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfileDTO {
    private String email;
    private String Name;
    private int age;
    private String gender;
    private String city;
}
