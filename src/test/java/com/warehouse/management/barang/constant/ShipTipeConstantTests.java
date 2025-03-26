package com.warehouse.management.barang.constant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTipeConstantTests {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testTIPE_IN() {
        // GIVEN - No setup needed
        // WHEN - Access the constant TIPE_IN
        String tipeIn = ShipTipeConstant.TIPE_IN;
        // THEN - Assert that the value is as expected
        assertEquals("IN", tipeIn);
    }

    @Test
    void testTIPE_OUT() {
        // GIVEN - No setup needed
        // WHEN - Access the constant TIPE_OUT
        String tipeOut = ShipTipeConstant.TIPE_OUT;
        // THEN - Assert that the value is as expected
        assertEquals("OUT", tipeOut);
    }
}