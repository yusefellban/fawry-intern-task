package com.fawry.exception;

public class InsufficientBalanceException extends IllegalStateException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
