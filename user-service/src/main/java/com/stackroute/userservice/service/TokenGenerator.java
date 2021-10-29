package com.stackroute.userservice.service;

import com.stackroute.userservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Siva
 * @Date 10/29/2021 11:35 AM
 */
@Slf4j
@Service
public class TokenGenerator implements SecurityTokenGenerator{
    public Map<String, String> generateToken(User user) {
        String jwtToken= Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretkey").compact();
        Map<String,String> map=new HashMap<String, String>();
        map.put("token",jwtToken);
        map.put("message","User successfully logged in");
        return map;
    }
}
