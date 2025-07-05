package com.fawry.model.products;


import com.fawry.model.customer.Expirable;
import com.fawry.model.customer.Product;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable {

    private final LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }



}
