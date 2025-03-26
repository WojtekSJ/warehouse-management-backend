package com.warehouse.management.barang.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShipServiceTest {

    @Autowired
    private ShipService shipService;

    @Test
    void testGetShipByBarang() {
        // GIVEN - A valid barang ID
        Long barangId = 1L;
        // WHEN - The method is called with the barang ID
        List<com.warehouse.management.barang.domain.dao.Ship> ships = shipService.getShipByBarang(barangId);
        // THEN - The list of ships is not empty and contains at least one element
        assertTrue(ships.size() > 0, "No ships found for barang ID: " + barangId);
    }

    @Test
    void testGetFindByShipper() {
        // GIVEN - A valid shipper ID
        Long shipperId = 1L;
        // WHEN - The method is called with the shipper ID
        List<com.warehouse.management.barang.domain.dto.ShippingTrackData> shippingTrackDatas = shipService.findByShipper(shipperId);
        // THEN - The list of ShippingTrackData is not empty and contains at least one element
        assertTrue(shippingTrackDatas.size() > 0, "No shipping track data found for shipper ID: " + shipperId);
    }
}