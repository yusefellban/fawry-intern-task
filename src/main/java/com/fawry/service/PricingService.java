package com.fawry.service;


import com.fawry.model.customer.CartItem;
import com.fawry.model.customer.Customer;

public class PricingService {

    public double calculateSubtotalAndReduceStock(Customer customer) {
        double subtotal = 0;
        for (CartItem item : customer.getCart().getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

}
