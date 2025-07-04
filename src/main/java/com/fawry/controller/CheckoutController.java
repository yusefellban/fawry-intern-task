package com.fawry.controller;

import com.fawry.model.Customer;
import com.fawry.service.CheckoutService;

public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController() {
        this.checkoutService = new CheckoutService();
    }

    public void handleCheckout(Customer customer) {
        try {
            checkoutService.checkout(customer);
            System.out.println(" Checkout completed successfully.");
        } catch (IllegalStateException e) {
            System.err.println(" Checkout failed: " + e.getMessage());
        }
    }
}
