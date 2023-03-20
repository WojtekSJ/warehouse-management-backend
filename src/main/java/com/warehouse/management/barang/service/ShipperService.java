package com.warehouse.management.barang.service;

import com.warehouse.management.barang.domain.dao.Ship;
import com.warehouse.management.barang.domain.dao.Shipper;
import com.warehouse.management.barang.domain.dto.ShippingTrackData;
import com.warehouse.management.barang.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private ShipService shipService;

    public List<Shipper> getAll() {
        return shipperRepository.findAll();
    }

    public Shipper getShipperById(Long id) {
        return shipperRepository.findById(id).get();
    }

    public Shipper saveShipper(Shipper shipper) {
        return shipperRepository.save(shipper);
    }

    public void deleteShipper(Long id) {
        shipperRepository.deleteById(id);
    }

    public List<ShippingTrackData> getShipByShipper(Long id) {
        return shipService.findByShipper(id);
    }
}
