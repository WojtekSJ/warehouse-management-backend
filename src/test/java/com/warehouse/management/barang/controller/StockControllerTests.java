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


class StockServiceTest {

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
    void addStock_Success() {
        // GIVEN
        StockShipRequestDTO request = new StockShipRequestDTO();
        request.setBarangId(1L);
        request.setShipperId(2L);
        request.setStock(5);
        request.setTipe("IN");

        when(stockRepository.save(any())).thenReturn(new Stock());

        // WHEN
        stockService.addStock(request);

        // THEN
        // Assertions for successful stock addition
    }

    @Test
    void addStock_BarangIdNotFound() {
        // GIVEN
        StockShipRequestDTO request = new StockShipRequestDTO();
        request.setBarangId(1L);
        request.setShipperId(2L);
        request.setStock(5);
        request.setTipe("IN");

        when(stockRepository.findById(request.getBarangId())).thenReturn(Optional.empty());

        // WHEN
        // THEN
        // Assertions for handling barangId not found scenario
    }


    public void addStock(StockShipRequestDTO request) {
        Stock stock = new Stock();
        stock.setBarangId(request.getBarangId());
        stock.setShipperId(request.getShipperId());
        stock.setStock(request.getStock());
        stock.setTipe(request.getTipe());

        stockRepository.save(stock);
    }
}