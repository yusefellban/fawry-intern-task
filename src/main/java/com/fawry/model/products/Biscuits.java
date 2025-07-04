package com.fawry.model.products;
// Biscuits.java


import com.fawry.model.ExpirableAndShippableProduct;

import java.time.LocalDate;

public class Biscuits extends ExpirableAndShippableProduct {
    public Biscuits(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, weight, expiryDate);

    }
}
