package com.ohgiraffers.section02.user_exception.exception;

public class PriceNegativeException extends Exception {
    public PriceNegativeException(String message) {
        super(message);
    }
}
