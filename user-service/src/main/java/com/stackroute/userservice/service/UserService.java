package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;

/**
 * @Author Siva
 * @Date 10/29/2021 10:41 AM
 */
public interface UserService {
    User saveUser (User user) throws UserAlreadyExistsException;
    User fingUserByEmailId (String email) throws UserNotFoundException;
}
