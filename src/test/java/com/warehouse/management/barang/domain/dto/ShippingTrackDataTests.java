package com.warehouse.management.barang.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ShippingTrackDataTests {
    private ShippingTrackData shippingTrackData;

    @BeforeEach
    void setUp() {
        shippingTrackData = new ShippingTrackData("Barang A", 10, new Date(), "Shipping");
    }

    @Test
    void testGetBarang() {
        // GIVEN - A ShippingTrackData object is created.
        // WHEN - The barang property is accessed.
        String actualBarang = shippingTrackData.getBarang();
        // THEN - The actual barang value matches the expected value.
        assertEquals("Barang A", actualBarang);
    }

    @Test
    void testGetStok() {
        // GIVEN - A ShippingTrackData object is created.
        // WHEN - The stok property is accessed.
        Integer actualStok = shippingTrackData.getStok();
        // THEN - The actual stok value matches the expected value.
        assertEquals(10, actualStok);
    }

    @Test
    void testGetTanggal() {
        // GIVEN - A ShippingTrackData object is created.
        // WHEN - The tanggal property is accessed.
        Date actualTanggal = shippingTrackData.getTanggal();
        // THEN - The actual tanggal value is not null.
        assertNotNull(actualTanggal);
    }

    @Test
    void testGetTipe() {
        // GIVEN - A ShippingTrackData object is created.
        // WHEN - The tipe property is accessed.
        String actualTipe = shippingTrackData.getTipe();
        // THEN - The actual tipe value matches the expected value.
        assertEquals("Shipping", actualTipe);
    }
}