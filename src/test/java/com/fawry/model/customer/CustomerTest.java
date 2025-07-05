package com.fawry.model.customer;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testCustomerInitialization() {
        Customer customer = new Customer("Yousef", 500.0);
        assertEquals("Yousef", customer.getName());
        assertEquals(500.0, customer.getBalance());
        assertNotNull(customer.getCart());
        assertTrue(customer.getCart().isEmpty());
    }

    @Test
    void testDeductValidAmount() {
        Customer customer = new Customer("Ali", 300.0);
        customer.deduct(100.0);
        assertEquals(200.0, customer.getBalance());
    }

    @Test
    void testDeductMoreThanBalanceThrows() {
        Customer customer = new Customer("Sara", 100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customer.deduct(150.0);
        });
        assertTrue(exception.getMessage().contains("insufficient balance"));
    }

    @Test
    void testSetName() {
        Customer customer = new Customer("Old Name", 100.0);
        customer.setName("New Name");
        assertEquals("New Name", customer.getName());
    }
}
