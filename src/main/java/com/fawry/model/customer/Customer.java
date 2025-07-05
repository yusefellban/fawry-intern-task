package com.fawry.model.customer;

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
            throw new IllegalArgumentException("Cannot complete transaction: " +
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

}
