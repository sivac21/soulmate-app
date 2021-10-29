package com.stackroute.userservice.service;

import com.stackroute.userservice.model.User;

import java.util.Map;

/**
 * @Author Siva
 * @Date 10/29/2021 4:06 PM
 */
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
