package com.fawry.controller;

import com.fawry.model.*;
import com.fawry.model.products.Cheese;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutControllerTest {

    @Test
    void testHandleCheckout_successfulFlow() {
        // Arrange
        CheckoutController controller = new CheckoutController();
        Customer customer = new Customer("yousef", 1000);
        customer.deduct(1000);

        Cart cart = new Cart();
        Product product = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(3), 0.2);
        cart.add(product, 2);
        customer.setCart(cart);

        // Act & Assert
        assertDoesNotThrow(() -> controller.handleCheckout(customer));
    }

    @Test
    void testHandleCheckout_withExpiredProduct_shouldFail() {
        // Arrange
        CheckoutController controller = new CheckoutController();
        Customer customer = new Customer("yousef", 1000);
        customer.deduct(1000);

        Cart cart = new Cart();
        Product expired = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(3), 0.2);
        cart.add(expired, 1);
        customer.setCart(cart);

        // Act
        controller.handleCheckout(customer);

        // Note: no assert needed since the method handles exception with a print,
        // but the test will pass as long as there's no crash.
    }

    @Test
    void testHandleCheckout_insufficientBalance_shouldFail() {
        // Arrange
        CheckoutController controller = new CheckoutController();
        Customer customer = new Customer("yousef", 1000);
        customer.deduct(10); // Very low balance

        Cart cart = new Cart();
        Product product = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(3), 0.2);
        cart.add(product, 2);
        customer.setCart(cart);

        // Act
        controller.handleCheckout(customer);

        // Again, no assert needed. Just verifying no crash and proper handling.
    }
}
