package com.fawry.service;

import com.fawry.model.*;

import java.util.List;

public class CheckoutService {

    private final ValidationService validationService;
    private final PricingService pricingService;
    private final ShippingService shippingService;

    /// Like Spring Dependency Injection, we can use constructor injection to inject the service
    public CheckoutService() {
        this.validationService = new ValidationService();
        this.pricingService = new PricingService();
        this.shippingService = new ShippingService();
    }

    public void checkout(Customer customer) {
        validationService.ensureCartNotEmpty(customer);
        validationService.ensureNoExpiredItems(customer);

        double subtotal = pricingService.calculateSubtotalAndReduceStock(customer);
        List<Shippable> shippableItems = shippingService.getShippableItems(customer);
        double shippingCost = shippingService.calculateShipping(shippableItems);

        double totalCost = subtotal + shippingCost;
        validationService.ensureSufficientBalance(customer, totalCost);

        customer.deduct(totalCost);
        shippingService.processShipping(shippableItems);
        ReceiptService.printReceipt(customer, subtotal, shippingCost, totalCost);
        customer.getCart().clear();
    }
}
