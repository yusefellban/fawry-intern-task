package com.fawry.model.products;


import com.fawry.model.customer.Product;
import com.fawry.model.customer.Shippable;

public class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ShippableProduct{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", weight=" + weight +
                '}';
    }
}
