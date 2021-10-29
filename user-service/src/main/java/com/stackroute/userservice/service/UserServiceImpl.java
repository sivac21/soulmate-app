package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import org.springframework.stereotype.Service;

/**
 * @Author Siva
 * @Date 10/29/2021 10:46 AM
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User fingUserByEmailId(String email) throws UserNotFoundException {
        return null;
    }
}
