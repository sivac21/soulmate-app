package com.stackroute.userservice.exception;

/**
 * @Author Siva
 * @Date 10/29/2021 10:45 AM
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
