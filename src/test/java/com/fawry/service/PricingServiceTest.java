package com.fawry.service;

import com.fawry.model.customer.Customer;
import com.fawry.model.customer.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import com.fawry.model.products.ExpirableAndShippableProduct;

public class PricingServiceTest {

    private PricingService pricingService;

    @BeforeEach
    void setUp() {
        pricingService = new PricingService();
    }

    @Test
    void testSubtotalAndStockReduction() {
        Customer customer = new Customer("Yousef", 1000.0);

        Product cheese = new ExpirableAndShippableProduct(
                "Cheese", 100.0, 10, LocalDate.now().plusDays(5), 0.5);
        Product biscuits = new ExpirableAndShippableProduct(
                "Biscuits", 50.0, 5, LocalDate.now().plusDays(10), 0.2);

        customer.getCart().add(cheese, 2);
        customer.getCart().add(biscuits, 1);

        double subtotal = pricingService.calculateSubtotalAndReduceStock(customer);

        assertEquals(250.0, subtotal, 0.001);

        assertEquals(8, cheese.getQuantity());
        assertEquals(4, biscuits.getQuantity());
    }
}
