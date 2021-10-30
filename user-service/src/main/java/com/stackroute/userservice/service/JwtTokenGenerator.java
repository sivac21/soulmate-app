package com.stackroute.userservice.service;

import com.stackroute.userservice.model.User;

/**
 * @Author Siva
 * @Date 10/30/2021 2:59 PM
 */
public interface JwtTokenGenerator {
    public String generateToken(User user);
}
