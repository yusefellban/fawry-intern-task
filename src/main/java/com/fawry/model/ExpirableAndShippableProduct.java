package com.fawry.model;

import java.time.LocalDate;

public abstract class ExpirableAndShippableProduct extends Product implements Shippable,Expirable{
    private final double weight;
    private final LocalDate expiryDate;

    public ExpirableAndShippableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
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
