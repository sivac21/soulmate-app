package com.stackroute.userservice.exception;

/**
 * @Author Siva
 * @Date 10/29/2021 10:49 AM
 */
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
