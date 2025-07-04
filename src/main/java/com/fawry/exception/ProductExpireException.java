package com.fawry.exception;

public class ProductExpireException extends IllegalStateException {
    public ProductExpireException(String productName, String message) {
        super(productName + message);
    }
}
