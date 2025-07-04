package com.fawry.model.products;

import com.fawry.model.ShippableProduct;

public class TV extends ShippableProduct {
    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity,weight);
    }
}
