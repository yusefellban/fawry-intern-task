package com.fawry.controller;


import com.fawry.model.customer.Customer;
import com.fawry.service.*;

public class CheckoutController {

    private final ValidationService validationService;
    private final PricingService checkoutReceiptService;
    private final ShippingService shippingService;
    private final ReceiptService checkoutLoggerService;

    /// Like Spring Dependency Injection, we can use constructor injection to inject the service
    public CheckoutController(ValidationService validationService, PricingService checkoutReceiptService, ShippingService shippingService, ReceiptService checkoutLoggerService) {
        this.validationService = validationService;
        this.checkoutReceiptService = checkoutReceiptService;
        this.shippingService = shippingService;
        this.checkoutLoggerService = checkoutLoggerService;
    }


    public void checkout(Customer customer) {
        validationService.ensureCartNotEmpty(customer);
        validationService.ensureNoExpiredItems(customer);

        double subtotal = checkoutReceiptService.calculateSubtotalAndReduceStock(customer);


        shippingService.shipping(customer);
        double shippingCost = shippingService.getShoppingCost();

        double totalCost = subtotal + shippingCost;
        validationService.ensureSufficientBalance(customer, totalCost);

        customer.deduct(totalCost);
        checkoutLoggerService.printReceipt(customer, subtotal, shippingCost);
        customer.getCart().clear();
    }
}
