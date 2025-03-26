package com.warehouse.management.barang.service;

import com.warehouse.management.barang.domain.dao.Ship;
import com.warehouse.management.barang.domain.dao.Stock;
import com.warehouse.management.barang.domain.dto.StockShipRequestDTO;
import com.warehouse.management.barang.repository.ShipRepository;
import com.warehouse.management.barang.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class StockServiceTests {
    @InjectMocks
    private StockService stockService;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private ShipRepository shipRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStok() {
        Stock stock = new Stock();
        stock.setId(1L);
        when(stockRepository.save(any(Stock.class))).thenReturn(stock);
        Stock savedStock = stockService.save(stock);
        assertNotNull(savedStock);
    }

    @Test
    void testAddStockShip_In() {
        StockShipRequestDTO request = new StockShipRequestDTO();
        request.setBarangId(1L);
        request.setShipperId(1L);
        request.setStock(5);
        request.setTipe("IN");
        Stock existingStock = new Stock();
        existingStock.setId(1L);
        existingStock.setStok(10);
        when(stockRepository.findById(1L)).thenReturn(Optional.of(existingStock));

        // WHEN
        Stock updatedStock = stockService.addStockShip(request);

        // THEN
        assertEquals(15, updatedStock.getStok());
    }

    @Test
    void testAddStockShip_Out() {
        StockShipRequestDTO request = new StockShipRequestDTO();
        request.setBarangId(1L);
        request.setShipperId(1L);
        request.setStock(5);
        request.setTipe("OUT");
        Stock existingStock = new Stock();
        existingStock.setId(1L);
        existingStock.setStok(10);
        when(stockRepository.findById(1L)).thenReturn(Optional.of(existingStock));

        // WHEN
        Stock updatedStock = stockService.addStockShip(request);

        // THEN
        assertEquals(5, updatedStock.getStok());
    }

    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }
}