package com.warehouse.management.barang.controller;

import com.warehouse.management.barang.domain.dao.Stock;
import com.warehouse.management.barang.domain.dto.StockShipRequestDTO;
import com.warehouse.management.barang.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("stock")
    public Stock saveStock(@RequestBody StockShipRequestDTO requestDTO){
        return stockService.addStockShip(requestDTO);
    }
}
