package com.fawry.model.customer;
public class Product {
    private String name;
    private double price;
    private int quantity;//in Stock

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public void reduceQuantity(int amount) {
        if (amount > quantity)
            throw new IllegalArgumentException(this.name+" : Not enough in stock");
        quantity -= amount;
    }
}

