package com.fawry.service;

import com.fawry.exception.*;
import com.fawry.model.customer.CartItem;
import com.fawry.model.customer.Customer;
import com.fawry.model.customer.Expirable;
import com.fawry.model.customer.Product;

import java.util.logging.Logger;


public class ValidationService {
    private static final Logger logger = Logger.getLogger(ValidationService.class.getName());
    public void ensureCartNotEmpty(Customer customer) {
        if (customer.getCart().isEmpty()) {
            logger.warning("Customer has no cart");
            throw new CartEmptyException("Cart is empty");
        }
    }

    public void ensureNoExpiredItems(Customer customer) {
        for (CartItem item : customer.getCart().getItems()) {
            Product product = item.getProduct();
            /// Pattern Matching with instanceof
            if (product instanceof Expirable expirable && expirable.isExpired()) {
                logger.warning("Product is expired: {}"+ product.getName());
                throw new ProductExpireException(product.getName() , " is expired");
            }
        }
    }

    public void ensureSufficientBalance(Customer customer, double total) {
        if (customer.getBalance() < total) {
            logger.warning("Customer balance is lower than total");
            throw new InsufficientBalanceException("Cannot complete transaction: " +
                    "insufficient balance in account. Required amount is " + total +
                    ", but available balance is " + customer.getBalance() + ".");
        }
    }
}