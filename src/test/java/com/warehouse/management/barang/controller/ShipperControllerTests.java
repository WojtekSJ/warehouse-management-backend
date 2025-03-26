package com.warehouse.management.barang.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShipperServiceTests {

    @InjectMocks
    private ShipperService shipperService;

    @Mock
    private com.warehouse.management.barang.domain.dao.ShipRepository shipRepository; 

    @Mock
    private ShipService shipService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllShippers() {
        // GIVEN
        List<com.warehouse.management.barang.domain.dao.Shipper> shippers = new ArrayList<>();
        when(shipRepository.findAll()).thenReturn(shippers);
        // WHEN
        List<com.warehouse.management.barang.domain.dao.Shipper> result = shipperService.getAll();
        // THEN
        assertEquals(shippers, result);
    }

    @Test
    void getShipperById() {
        // GIVEN
        Long id = 1L;
        com.warehouse.management.barang.domain.dao.Shipper shipper = new com.warehouse.management.barang.domain.dao.Shipper();
        when(shipRepository.findById(id)).thenReturn(java.util.Optional.of(shipper));
        // WHEN
        com.warehouse.management.barang.domain.dao.Shipper result = shipperService.getShipperById(id);
        // THEN
        assertEquals(shipper, result);
    }

    @Test
    void getShippingTrackData() {
        // GIVEN
        Long id = 1L;
        List<com.warehouse.management.barang.domain.dto.ShippingTrackData> shippingTrackDataList = new ArrayList<>();
        when(shipService.getShippingTrackData(id)).thenReturn(shippingTrackDataList);
        // WHEN
        List<com.warehouse.management.barang.domain.dto.ShippingTrackData> result = shipperService.getShippingTrackData(id);
        // THEN
        assertEquals(shippingTrackDataList, result);
    }
}