package com.fawry.exception;

public class CartEmptyException extends IllegalStateException {
    public CartEmptyException(String message) {
        super(message);
    }
}
