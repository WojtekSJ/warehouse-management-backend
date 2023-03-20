package com.warehouse.management.barang.service;

import com.warehouse.management.barang.domain.dao.Barang;
import com.warehouse.management.barang.domain.dao.Stock;
import com.warehouse.management.barang.domain.dto.BarangStockData;
import com.warehouse.management.barang.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BarangService {
    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private StockService stockService;

    public List<BarangStockData> getAllBarang() {
//        return barangRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return barangRepository.barangAllWithStock();
    }

    public Barang saveBarang(Barang barang) {
        boolean isCreated = false;

        if (Objects.isNull(barang.getId())) {
            isCreated = true;
        }

        barang = barangRepository.save(barang);

        if (isCreated) {
            Stock stock = Stock.builder()
                    .barangId(barang.getId())
                    .stok(0)
                    .build();

            stockService.saveStok(stock);
        }

        return barang;
    }

    public Barang updateBarang(Barang barang) {
        Optional<Barang> barangOptional = barangRepository.findById(barang.getId());

        if (!barangOptional.isPresent()) {
            throw new RuntimeException("Barang not found");
        }

        return barangRepository.save(barang);
    }

    public void deleteBarang(Long id) {
        Optional<Barang> barang = barangRepository.findById(id);

        if (!barang.isPresent()) {
            throw new RuntimeException("Barang not found");
        }

        stockService.deleteStokByBarang(id);

        barangRepository.deleteById(id);
    }

    public Barang getBarangById(Long id) {
        Optional<Barang> barang = barangRepository.findById(id);

        if (!barang.isPresent()) {
            throw new RuntimeException("Barang not found");
        }

        return barang.get();
    }
}
