package com.warehouse.management.barang.constant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipeBarangConstantTests {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetTIPE_PAKAIAN() {
        // GIVEN - 
        // WHEN - 
        String actual = TipeBarangConstant.TIPE_PAKAIAN;
        // THEN - The returned value should be "PAKAIAN"
        assertEquals("PAKAIAN", actual);
    }

    @Test
    void testGetTIPE_ELEKTRONIK() {
        // GIVEN - 
        // WHEN - 
        String actual = TipeBarangConstant.TIPE_ELEKTRONIK;
        // THEN - The returned value should be "ELEKTRONIK"
        assertEquals("ELEKTRONIK", actual);
    }
}