package com.example.library.exception;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 10:43
 */
public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message) {
        super(message);
    }
}
