package com.fawry.model.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart cart;
    private Product cheese;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        cheese = new Product("Cheese", 100.0, 10);
    }

    @Test
    void testAddProductToCart() {
        cart.add(cheese, 2);
        assertEquals(1, cart.getItems().size());
        assertEquals(2, cart.getItems().get(0).getQuantity());
        assertEquals("Cheese", cart.getItems().get(0).getProduct().getName());
    }

    @Test
    void testAddMoreThanAvailableStockThrows() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.add(cheese, 11);
        });
        assertTrue(exception.getMessage().contains("Not enough stock"));
    }

    @Test
    void testRemoveProductFromCart() {
        cart.add(cheese, 2);
        cart.removeItem(cheese);
        assertTrue(cart.isEmpty());
    }

    @Test
    void testClearCart() {
        cart.add(cheese, 1);
        cart.clear();
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void testIsEmptyInitially() {
        assertTrue(cart.isEmpty());
    }
}
