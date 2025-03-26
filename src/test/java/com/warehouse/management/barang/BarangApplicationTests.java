package com.warehouse.management.barang.domain.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BarangTests {

    private Barang barang;

    @BeforeEach
    void setUp() {
        barang = new Barang();
        barang.setNama("Barang Test");
        barang.setKategori("Kategori Test");
        barang.setBerat(10);
    }

    @Test
    void testConstructor() {
        assertNotNull(barang.getId());
        assertEquals("Barang Test", barang.getNama());
        assertEquals("Kategori Test", barang.getKategori());
        assertEquals(10, barang.getBerat());
    }

    @Test
    void testGetters() {
        assertEquals("Barang Test", barang.getNama());
        assertEquals("Kategori Test", barang.getKategori());
        assertEquals(10, barang.getBerat());
    }

    @Test
    void testSetters() {
        barang.setNama("New Barang Name");
        barang.setKategori("New Kategori");
        barang.setBerat(20);

        assertEquals("New Barang Name", barang.getNama());
        assertEquals("New Kategori", barang.getKategori());
        assertEquals(20, barang.getBerat());
    }

    @Test
    void testCalculateTotalWeight() {
        barang.addItem(new Item("Item 1", 5));
        barang.addItem(new Item("Item 2", 7));
        assertEquals(22, barang.calculateTotalWeight());
    }

    @Test
    void testCalculateTotalWeightEmpty() {
        assertEquals(0, barang.calculateTotalWeight());
    }
}