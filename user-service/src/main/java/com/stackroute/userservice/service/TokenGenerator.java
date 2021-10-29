package com.stackroute.userservice.service;

import com.stackroute.userservice.model.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Siva
 * @Date 10/29/2021 11:35 AM
 */
@Slf4j
public class TokenGenerator {
    /*Method that accepts validated User and returns a generated jwt token */
    public static String generateToken(User user){
        log.debug("Inside generate token");
        //TODO generate jwt token
        return "dummy token";
    }
}
