package com.fawry.model;

import com.fawry.exception.InsufficientBalanceException;

public class Customer {
    private String name;
    private double balance;
    private final Cart cart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public double getBalance() {
        return balance;
    }

    public void deduct(double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("Cannot complete transaction: " +
                    "insufficient balance in account. Required amount is "
                    + amount + ", but available balance is " + balance + ".");
        }
        balance -= amount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCart(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        this.cart.clear(); // Clear existing items before setting a new cart
        this.cart.getItems().addAll(cart.getItems()); // Add items from the new cart
    }
}
