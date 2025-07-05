package com.fawry.service;

import com.fawry.model.customer.CartItem;
import com.fawry.model.customer.Customer;
import com.fawry.model.customer.Shippable;


public class ShippingService {
    private int shoppingCost ;
    public void shipping(Customer customer) {
        System.out.println("*** Shipment notice ***");
        double totalWeight = 0;
        for (CartItem item : customer.getCart().getItems()) {
            if (item.getProduct() instanceof Shippable shippableProduct) {
                System.out.println(item.getQuantity() + " x  " + item.getProduct().getName() + " \t" + (int) (shippableProduct.getWeight() * 1000) + "g");
                totalWeight += shippableProduct.getWeight();
                this.shoppingCost +=10;
            }
        }
        System.out.println("Total package weight " + totalWeight + ((totalWeight >= 1) ? "kg" : "g"));

    }
    public int getShoppingCost() {
        return shoppingCost;
    }
}
