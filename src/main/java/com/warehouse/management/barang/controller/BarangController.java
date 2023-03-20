package com.warehouse.management.barang.controller;

import com.warehouse.management.barang.domain.dao.Barang;
import com.warehouse.management.barang.domain.dao.Ship;
import com.warehouse.management.barang.domain.dto.BarangStockData;
import com.warehouse.management.barang.domain.dto.ResponseData;
import com.warehouse.management.barang.service.BarangService;
import com.warehouse.management.barang.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BarangController {

    @Autowired
    private BarangService barangService;

    @Autowired
    private ShipService shipService;

    @GetMapping("barang")
    public List<BarangStockData> getAllBarang() {
        return barangService.getAllBarang();
    }

    @PostMapping("barang")
    public ResponseEntity<ResponseData<Barang>> saveBarang(@Valid @RequestBody Barang barang, Errors errors) {
        ResponseData<Barang> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(barangService.saveBarang(barang));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("barang/{id}")
    public Barang getBarangById(@PathVariable Long id) {
        return barangService.getBarangById(id);
    }

    @PutMapping("barang")
    public ResponseEntity<ResponseData<Barang>> updateBarang(@Valid @RequestBody Barang barang, Errors errors) {
        ResponseData<Barang> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData); // Return 400 Bad Request with error messages
        }

        responseData.setStatus(true);
        responseData.setPayload(barangService.updateBarang(barang));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("barang/{id}")
    public void deleteBarang(@PathVariable Long id) {
        barangService.deleteBarang(id);
    }

    @GetMapping("barang/{id}/ship")
    public List<Ship> getBarangShip(@PathVariable Long id) {
        return shipService.getShipByBarang(id);
    }
}
