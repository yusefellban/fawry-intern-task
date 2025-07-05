package com.fawry.model.customer;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity())
            throw new IllegalArgumentException(product.getName()+"Not enough stock for ");
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }
}
