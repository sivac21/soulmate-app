package com.stackroute.soulmateservice.service;

import com.stackroute.soulmateservice.model.User;
import com.stackroute.soulmateservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User deleteUser(String email) {
        User user = null;
        Optional optional = userRepository.findById(email);
        if (optional.isPresent())
        {
            user = userRepository.findById(email).get();
            userRepository.deleteById(email);
        }
        return user;
    }

    @Override
    public User updateUser(User user)
    {
       User updatedUser = null;
       Optional optional = userRepository.findById(user.getEmail());
       if (optional.isPresent()){
           User getUser = userRepository.findById(user.getEmail()).get();
           getUser.setEmail(user.getEmail());
           updatedUser = saveUser(getUser);
       }
        return updatedUser;
    }

    @Override
    public User getUserByemail(String email)
    {
        User user = null;
        user = userRepository.findById(email).get();
        return user;
    }
}
