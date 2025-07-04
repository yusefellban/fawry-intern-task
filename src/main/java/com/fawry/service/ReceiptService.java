package com.fawry.service;

import com.fawry.model.*;

public class ReceiptService {
    public static void printReceipt(Customer customer, double subtotal, double shipping, double total) {
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : customer.getCart().getItems()) {
            System.out.println(item.quantity + "x " + item.product.getName() + " \t" + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal  \t\t" + subtotal);
        System.out.println("Shipping  \t\t" + shipping);
        System.out.println("Amount  \t\t" + total);
        System.out.println("Remaining balance:\t" + customer.getBalance());
    }
}

