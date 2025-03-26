package com.warehouse.management.barang.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockShipRequestDTOTests {
    private StockShipRequestDTO stockShipRequestDTO;

    @BeforeEach
    void setUp() {
        stockShipRequestDTO = new StockShipRequestDTO();
    }

    @Test
    void testGettersAndSetters() {
        // GIVEN a StockShipRequestDTO object
        // WHEN setting values for barangId, shipperId, stock, and tipe
        stockShipRequestDTO.setBarangId(1L);
        stockShipRequestDTO.setShipperId(2L);
        stockShipRequestDTO.setStock(3);
        stockShipRequestDTO.setTipe("test");
        // THEN the getters should return the set values
        assertEquals(1L, stockShipRequestDTO.getBarangId());
        assertEquals(2L, stockShipRequestDTO.getShipperId());
        assertEquals(3, stockShipRequestDTO.getStock());
        assertEquals("test", stockShipRequestDTO.getTipe());
    }
}