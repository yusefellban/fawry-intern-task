package com.fawry.service;

import com.fawry.exception.CartEmptyException;
import com.fawry.exception.InsufficientBalanceException;
import com.fawry.exception.ProductExpireException;
import com.fawry.model.*;

public class ValidationService {

    public void ensureCartNotEmpty(Customer customer) {
        if (customer.getCart().isEmpty()) {
            throw new CartEmptyException("Cart is empty");
        }
    }

    public void ensureNoExpiredItems(Customer customer) {
        for (CartItem item : customer.getCart().getItems()) {
            Product product = item.product;
            /// Pattern Matching with instanceof
            if (product instanceof Expirable expirable && expirable.isExpired()) {
                throw new ProductExpireException(product.getName() , " is expired");
            }
        }
    }

    public void ensureSufficientBalance(Customer customer, double total) {
        if (customer.getBalance() < total) {
            throw new InsufficientBalanceException("Cannot complete transaction: " +
                    "insufficient balance in account. Required amount is " + total +
                    ", but available balance is " + customer.getBalance() + ".");
        }
    }
}
