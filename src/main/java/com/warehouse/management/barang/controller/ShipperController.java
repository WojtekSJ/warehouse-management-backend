package com.warehouse.management.barang.controller;

import java.util.List;

import javax.validation.Valid;

import com.warehouse.management.barang.domain.dto.ShippingTrackData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.management.barang.domain.dao.Ship;
import com.warehouse.management.barang.domain.dao.Shipper;
import com.warehouse.management.barang.domain.dto.ResponseData;
import com.warehouse.management.barang.service.ShipperService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @GetMapping("shipper")
    public List<Shipper> getAll() {
        return shipperService.getAll();
    }

    @GetMapping("shipper/{id}")
    public Shipper getShipperById(@PathVariable Long id) {
        return shipperService.getShipperById(id);
    }

    @PostMapping(value="shipper", consumes="application/json", produces="application/json")
    public ResponseEntity<ResponseData<Shipper>> saveShipper(@Valid @RequestBody Shipper shipper, Errors errors) {
        ResponseData<Shipper> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(shipperService.saveShipper(shipper));
        return ResponseEntity.ok(responseData);
    }

    @PutMapping(value="shipper", consumes="application/json", produces="application/json")
    public ResponseEntity<ResponseData<Shipper>> updateShipper(@Valid @RequestBody Shipper shipper, Errors errors) {
        ResponseData<Shipper> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(shipperService.saveShipper(shipper));
        return ResponseEntity.ok(responseData);
    }
    
    @DeleteMapping("shipper/{id}")
    public void deleteShipper(@PathVariable Long id) {
        shipperService.deleteShipper(id);
    }

    @GetMapping("shipper/{id}/shipping")
    public List<ShippingTrackData> getShipByShipper(@PathVariable Long id) {
        return shipperService.getShipByShipper(id);
    }
}
