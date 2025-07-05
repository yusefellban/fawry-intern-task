package com.fawry.model.products;

import com.fawry.model.customer.Expirable;
import com.fawry.model.customer.Product;
import com.fawry.model.customer.Shippable;

import java.time.LocalDate;

public class ExpirableAndShippableProduct extends Product implements Shippable, Expirable {

    private final double weight;
    private final LocalDate expiryDate;

    public ExpirableAndShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
