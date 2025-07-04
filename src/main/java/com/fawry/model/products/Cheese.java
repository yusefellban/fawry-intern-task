package com.fawry.model.products;


import com.fawry.model.ExpirableAndShippableProduct;

import java.time.LocalDate;

public class Cheese extends ExpirableAndShippableProduct {

    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, weight, expiryDate);

    }


}

