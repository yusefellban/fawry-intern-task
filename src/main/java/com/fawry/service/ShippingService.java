package com.fawry.service;

import com.fawry.model.*;

import java.util.ArrayList;
import java.util.List;

public class ShippingService {

    public List<Shippable> getShippableItems(Customer customer) {
        List<Shippable> items = new ArrayList<>();
        for (CartItem item : customer.getCart().getItems()) {
            if (item.product instanceof Shippable shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    items.add(shippable);
                }
            }
        }
        return items;
    }

    public double calculateShipping(List<Shippable> items) {
        return items.size() * 10;
    }

    public void processShipping(List<Shippable> items) {
        if (!items.isEmpty()) {
            ShippingLogger.ship(items);  ///print the shipping notice
        }
    }
}
