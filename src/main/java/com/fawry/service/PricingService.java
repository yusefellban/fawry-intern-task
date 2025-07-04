package com.fawry.service;

import com.fawry.model.*;

public class PricingService {

    public double calculateSubtotalAndReduceStock(Customer customer) {
        double subtotal = 0;
        for (CartItem item : customer.getCart().getItems()) {
            item.product.reduceQuantity(item.quantity);
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }
}
