package com.warehouse.management.barang.domain.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockTests {
    private Stock stock;

    @BeforeEach
    void setUp() {
        stock = new Stock();
    }

    @Test
    void testStockCreation() {
        // GIVEN - A new Stock object is created
        // WHEN - The id, barangId, and stok are set
        stock.setId(1L);
        stock.setBarangId(2L);
        stock.setStok(5);
        // THEN - The id, barangId, and stok are correctly set
        assertEquals(1L, stock.getId());
        assertEquals(2L, stock.getBarangId());
        assertEquals(5, stock.getStok());
    }
}