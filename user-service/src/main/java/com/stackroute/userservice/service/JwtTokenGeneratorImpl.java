package com.stackroute.userservice.service;

import com.stackroute.userservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author Siva
 * @Date 10/30/2021 2:59 PM
 */
@Slf4j
@Service
public class JwtTokenGeneratorImpl implements JwtTokenGenerator{
    @Override
    public String generateToken(User user) {
        log.debug("Inside generate token");
        String jwtToken="";
        jwtToken= Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretkey").compact();
        String token = new String();
        token.startsWith("token");
        token.startsWith("message");
        return token;
    }

}
