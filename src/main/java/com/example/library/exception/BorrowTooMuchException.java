package com.example.library.exception;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/10 13:10
 */
public class BorrowTooMuchException extends Exception{

    public BorrowTooMuchException(String message) {
        super(message);
    }
}
