package com.stackroute.soulmateservice.controller;

import com.stackroute.soulmateservice.model.User;
import com.stackroute.soulmateservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user)
    {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return new ResponseEntity<List<User>>((List<User>) userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("user/{email}")
    public ResponseEntity<User> deleteUser(@PathVariable("email") String email)
    {
        return new ResponseEntity<>(userService.deleteUser(email),HttpStatus.OK);
    }

    @PutMapping("user")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @GetMapping("users/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email)
    {
        return new ResponseEntity<>(userService.getUserByemail(email),HttpStatus.OK);
    }
}
