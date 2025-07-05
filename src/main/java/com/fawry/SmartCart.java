package com.fawry;

import com.fawry.controller.CheckoutController;
import com.fawry.model.customer.Customer;
import com.fawry.model.customer.Product;
import com.fawry.model.products.*;
import com.fawry.service.*;


import java.time.LocalDate;

public class SmartCart {
    public static void main(String[] args) {
        Customer customer = new Customer("Yousef", 500);

        Product biscuits = new ExpirableAndShippableProduct("Biscuits", 150, 2, LocalDate.now().plusDays(1), 0.7);
        Product tv = new ShippableProduct("TV", 10, 1, 10.5);
        Product mobile = new ShippableProduct("mobile", 10, 5, 10.5);
        Product scratchCard = new Product("ScratchCard", 50, 10);

        customer.getCart().add(biscuits, 1);
        customer.getCart().add(scratchCard, 1);
        customer.getCart().add(tv, 1);
        customer.getCart().add(mobile, 3);


        CheckoutController checkoutService = new CheckoutController(
                new ValidationService(),
                new PricingService(),
                new ShippingService(),
                new ReceiptService()
        );
        checkoutService.checkout(customer);
    }
}
