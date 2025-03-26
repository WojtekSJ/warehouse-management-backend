package com.warehouse.management.barang.domain.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShipperTests {
    private Shipper shipper;

    @BeforeEach
    void setUp() {
        shipper = new Shipper();
    }

    @Test
    void testShipperConstructor() {
        // GIVEN - A new Shipper object is created
        // WHEN - The constructor is called
        // THEN - The id, nama, and codeShipper are null
        assertNull(shipper.getId());
        assertNull(shipper.getNama());
        assertNull(shipper.getCodeShipper());
    }

    @Test
    void testSettersAndGetters() {
        // GIVEN - A new Shipper object is created
        // WHEN - The setters are called to set the values for id, nama, and codeShipper
        // THEN - The getters return the expected values
        shipper.setId(1L);
        shipper.setNama("Test Nama");
        shipper.setCodeShipper("TEST001");
        assertEquals(1L, shipper.getId());
        assertEquals("Test Nama", shipper.getNama());
        assertEquals("TEST001", shipper.getCodeShipper());
    }
}