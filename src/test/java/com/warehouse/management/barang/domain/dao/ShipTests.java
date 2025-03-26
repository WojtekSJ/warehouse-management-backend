package com.warehouse.management.barang.domain.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShipTests {
    private Ship ship;

    @BeforeEach
    void setUp() {
        ship = new Ship();
    }

    @Test
    void testShipConstructor() {
        // GIVEN - A new Ship object is created
        // WHEN - The constructor is called
        // THEN - The id, barangId, shipperId, stok, tipe, and tanggal are all null
        assertNull(ship.getId());
        assertNull(ship.getBarangId());
        assertNull(ship.getShipperId());
        assertNull(ship.getStok());
        assertNull(ship.getTipe());
        assertNull(ship.getTanggal());
    }
}