package com.fawry.service;
import com.fawry.model.customer.CartItem;
import com.fawry.model.customer.Customer;


public class ReceiptService {
    public void printReceipt(Customer customer, double subtotal, double shipping) {
        System.out.println("*************************************");
        System.out.println("** Checkout receipt **");
        for (CartItem item : customer.getCart().getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " \t" + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal  \t\t" + subtotal);
        System.out.println("Shipping  \t\t" + shipping);
        System.out.println("Amount  \t\t" + (subtotal+ shipping));
        System.out.println("----------------------");
        System.out.println("Remaining balance:\t" + customer.getBalance());
    }
}
