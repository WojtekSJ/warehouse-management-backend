package com.warehouse.management.barang.service;

import com.warehouse.management.barang.domain.dao.Ship;
import com.warehouse.management.barang.domain.dto.ShippingTrackData;
import com.warehouse.management.barang.repository.ShipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShipServiceTest {
    @Mock
    private ShipRepository shipRepository;

    @InjectMocks
    private ShipService shipService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetShipsByShipperId_Success() {
        // GIVEN
        Long shipperId = 1L;
        List<Ship> ships = new ArrayList<>();
        when(shipRepository.findByShipperId(shipperId)).thenReturn(ships);

        // WHEN
        List<Ship> result = shipService.getShipsByShipperId(shipperId);

        // THEN
        assertEquals(ships, result);
    }

    @Test
    void testGetShippingTrackData_Success() {
        // GIVEN
        Long id = 1L;
        Ship ship = new Ship();
        when(shipRepository.findById(id)).thenReturn(Optional.of(ship));

        // WHEN
        ShippingTrackData result = shipService.getShippingTrackData(id);

        // THEN
        assertNotNull(result);
    }

    @Test
    void testGetShippingTrackData_NotFound() {
        // GIVEN
        Long id = 1L;
        when(shipRepository.findById(id)).thenReturn(Optional.empty());

        // WHEN
        ShippingTrackData result = shipService.getShippingTrackData(id);

        // THEN
        assertNull(result);
    }   
}