package com.example.library.exception;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/10 13:12
 */
public class BookExpiredException extends Exception{
    public BookExpiredException(String message) {
        super(message);
    }
}
