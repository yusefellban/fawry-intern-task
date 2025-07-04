package com.fawry;

import com.fawry.controller.CheckoutController;
import com.fawry.model.*;
import com.fawry.model.products.*;


import java.time.LocalDate;

public class SmartCart {
    public static void main(String[] args) {
        Customer customer = new Customer("Yousef", 500);

        Product cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(3), 0.2);
        Product biscuits = new Biscuits("Biscuits", 150, 2, LocalDate.now().plusDays(1), 0.7);
        Product tv = new TV("TV", 10, 1, 10.5);
        Product scratchCard = new ScratchCard("ScratchCard", 50, 10);

        customer.getCart().add(cheese, 2);
        customer.getCart().add(biscuits, 1);
        customer.getCart().add(scratchCard, 1);
        customer.getCart().add(tv, 1);

        CheckoutController checkoutController = new CheckoutController();

        checkoutController.handleCheckout(customer);
    }
}
