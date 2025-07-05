package com.fawry.service;

import com.fawry.model.customer.Customer;
import com.fawry.model.customer.Product;
import com.fawry.model.products.ExpirableAndShippableProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingServiceTest {

    private ShippingService shippingService;
    private Customer customer;

    @BeforeEach
    void setUp() {
        shippingService = new ShippingService();
        customer = new Customer("Yousef", 1000.0);
    }

    @Test
    void testShippingCostAndWeightAreCalculatedCorrectly() {
        Product cheese = new ExpirableAndShippableProduct(
                "Cheese", 100.0, 10, LocalDate.now().plusDays(10), 0.4);  // 400g
        Product tv = new ExpirableAndShippableProduct(
                "TV", 800.0, 5, LocalDate.now().plusDays(15), 0.7);       // 700g

        customer.getCart().add(cheese, 2);
        customer.getCart().add(tv, 1);


        shippingService.shipping(customer);
        int shippingCost = shippingService.getShoppingCost();


        assertEquals(20, shippingCost);


    }

    @Test
    void testNoShippableProductsResultsInZeroShippingCost() {

        shippingService.shipping(customer);
        int cost = shippingService.getShoppingCost();


        assertEquals(0, cost);
    }
}
