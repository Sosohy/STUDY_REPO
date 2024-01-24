package com.ohgiraffers.section02.user_exception.exception;

public class MoneyNegativeException extends Exception {
    public MoneyNegativeException(String message) {
        super(message);
    }
}
