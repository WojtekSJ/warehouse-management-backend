package com.warehouse.management.barang.service;

import com.warehouse.management.barang.domain.dao.Ship;
import com.warehouse.management.barang.domain.dto.ShippingTrackData;
import com.warehouse.management.barang.repository.ShipRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    public List<Ship> getShipByBarang(Long id) {
        return shipRepository.findByBarangId(id);
    }

    public List<ShippingTrackData> findByShipper(Long id) {
        return shipRepository.findByTrackShipper(id);
    }
}
