package com.warehouse.management.barang.domain.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BarangTests {
    private Barang barang;

    @BeforeEach
    void setUp() {
        barang = new Barang();
    }

    @Test
    void testBarangCreation() {
        // GIVEN - A new Barang object is created
        // WHEN - The object's properties are set
        barang.setNama("Test Barang");
        barang.setKategori("Test Kategori");
        barang.setBerat(10);
        // THEN - The properties are correctly set
        assertEquals("Test Barang", barang.getNama());
        assertEquals("Test Kategori", barang.getKategori());
        assertEquals(10, barang.getBerat());
    }
}