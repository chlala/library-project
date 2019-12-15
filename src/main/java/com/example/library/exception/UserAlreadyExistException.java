package com.example.library.exception;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 11:50
 */
public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
