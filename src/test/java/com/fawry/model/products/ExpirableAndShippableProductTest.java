package com.fawry.model.products;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpirableAndShippableProductTest {

    @Test
    void testProductInitialization() {
        ExpirableAndShippableProduct product = new ExpirableAndShippableProduct(
                "Cheese", 100.0, 10, LocalDate.now().plusDays(5), 0.5);

        assertEquals("Cheese", product.getName());
        assertEquals(100.0, product.getPrice());
        assertEquals(10, product.getQuantity());
        assertEquals(0.5, product.getWeight());
        assertFalse(product.isExpired());
    }

    @Test
    void testProductExpired() {
        ExpirableAndShippableProduct expiredProduct = new ExpirableAndShippableProduct(
                "Old Cheese", 50.0, 5, LocalDate.now().minusDays(1), 0.3);

        assertTrue(expiredProduct.isExpired(), "Product should be expired");
    }

    @Test
    void testReduceQuantityValid() {
        ExpirableAndShippableProduct product = new ExpirableAndShippableProduct(
                "Cheese", 100.0, 10, LocalDate.now().plusDays(5), 0.5);

        product.reduceQuantity(3);
        assertEquals(7, product.getQuantity());
    }

    @Test
    void testReduceQuantityExceedsStockThrowsException() {
        ExpirableAndShippableProduct product = new ExpirableAndShippableProduct(
                "Cheese", 100.0, 5, LocalDate.now().plusDays(5), 0.5);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.reduceQuantity(6);
        });

        assertFalse(exception.getMessage().toLowerCase().contains("insufficient"));
    }
}
