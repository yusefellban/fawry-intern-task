package com.fawry.exception;

public class EmptyStockException extends IllegalStateException {
    public EmptyStockException(String productName, String message) {
        super(productName + message);
    }
}
