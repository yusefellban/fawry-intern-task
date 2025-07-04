package com.fawry.service;

import com.fawry.exception.CartEmptyException;
import com.fawry.model.*;
import com.fawry.model.products.ScratchCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ValidationServiceTest {

    private ValidationService validationService;
    private Customer customer;

    @BeforeEach
    void setUp() {
        validationService = new ValidationService();
        customer = new Customer("Yousef", 500);
    }

    // ---------- ensureCartNotEmpty ----------
    @Test
    void testEnsureCartNotEmpty_shouldThrow_whenCartIsEmpty() {
        assertThrows(CartEmptyException.class, () -> {
            validationService.ensureCartNotEmpty(customer);
        });
    }

    @Test
    void testEnsureCartNotEmpty_shouldPass_whenCartHasItems() {
        CartItem item = new CartItem(new Product("TV", 1000, 5), 1);
        customer.getCart().add(item.product, item.quantity);

        assertDoesNotThrow(() -> validationService.ensureCartNotEmpty(customer));
    }


    @Test
    void testEnsureNoExpiredItems_shouldPass_whenAllItemsAreValid() {
        Product freshProduct = new ScratchCard("ScratchCard", 50, 10);

        customer.getCart().add(freshProduct, 1);

        assertDoesNotThrow(() -> validationService.ensureNoExpiredItems(customer));
    }

    @Test
    void testEnsureSufficientBalance_shouldPass_whenBalanceIsEnough() {
        customer.deduct(200);

        assertDoesNotThrow(() -> {
            validationService.ensureSufficientBalance(customer, 100);
        });
    }
}
