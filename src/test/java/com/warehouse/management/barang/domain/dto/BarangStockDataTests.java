package com.warehouse.management.barang.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarangStockDataTests {
    private BarangStockData barangStockData;

    @BeforeEach
    void setUp() {
        barangStockData = new BarangStockData();
    }

    @Test
    void testGettersAndSetters() {
        // GIVEN - Set values for the properties
        barangStockData.setId(1L);
        barangStockData.setNama("Barang A");
        barangStockData.setKategori("Elektronik");
        barangStockData.setBerat(500);
        barangStockData.setStok(100);

        // THEN - Assert that the values are set correctly
        assertEquals(1L, barangStockData.getId());
        assertEquals("Barang A", barangStockData.getNama());
        assertEquals("Elektronik", barangStockData.getKategori());
        assertEquals(500, barangStockData.getBerat());
        assertEquals(100, barangStockData.getStok());
    }
}