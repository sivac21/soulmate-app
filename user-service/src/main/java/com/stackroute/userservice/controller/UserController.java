package com.stackroute.userservice.controller;

import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.security.SecurityTokenGenerator;
import com.stackroute.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Siva
 * @Date 10/29/2021 11:43 AM
 */

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/loginuser")
    public ResponseEntity<?> authenticateUser (@RequestBody User user){
        log.debug("Login request received for user" + user + "at " + java.time.LocalDateTime.now());
        ResponseEntity responseEntity = null;
        Map<String, String> map = null;
        try {
            boolean result = userService.validateUser(user);
            if (result){
               map=securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity<>(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
