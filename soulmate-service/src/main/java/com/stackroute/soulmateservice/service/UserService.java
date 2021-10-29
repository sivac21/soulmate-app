package com.stackroute.soulmateservice.service;

import com.stackroute.soulmateservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User deleteUser(String email);
    User updateUser(User user);
    User getUserByemail(String email);
}
