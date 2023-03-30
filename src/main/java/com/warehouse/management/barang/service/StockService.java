package com.warehouse.management.barang.service;

import com.warehouse.management.barang.constant.ShipTipeConstant;
import com.warehouse.management.barang.domain.dao.Ship;
import com.warehouse.management.barang.domain.dao.Stock;
import com.warehouse.management.barang.domain.dto.StockShipRequestDTO;
import com.warehouse.management.barang.repository.ShipRepository;
import com.warehouse.management.barang.repository.StockRepository;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ShipRepository shipRepository;

    public Stock saveStok(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStokByBarang(Long id) {
        stockRepository.deleteByBarangId(id);
    }

    public Stock addStockShip(StockShipRequestDTO requestDTO) {
        Optional<Stock> stockOptional = stockRepository.findByBarangId(requestDTO.getBarangId());
    
        if (!stockOptional.isPresent()) {
            throw new RuntimeException("Stock not found");
        }
    
        Stock stock = stockOptional.get();
    
        Ship ship = Ship.builder()
                .barangId(requestDTO.getBarangId())
                .shipperId(requestDTO.getShipperId())
                .stok(requestDTO.getStock())
                .tipe(requestDTO.getTipe())
                .tanggal(new Date())
                .build();
    
        switch (requestDTO.getTipe()) {
            case ShipTipeConstant.TIPE_IN:
                shipRepository.save(ship);
                stock.setStok(stock.getStok() + requestDTO.getStock());
                break;
            case ShipTipeConstant.TIPE_OUT:
                if (stock.getStok() < requestDTO.getStock()) {
                    throw new RuntimeException("Stock not enough");
                }
    
                shipRepository.save(ship);
                stock.setStok(stock.getStok() - requestDTO.getStock());
                break;
            default:
                throw new RuntimeException("Tipe not found");
        }
        
        return stockRepository.save(stock);
    }
}
