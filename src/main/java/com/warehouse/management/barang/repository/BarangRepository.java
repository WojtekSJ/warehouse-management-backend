package com.warehouse.management.barang.repository;

import com.warehouse.management.barang.domain.dao.Barang;
import com.warehouse.management.barang.domain.dto.BarangStockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {

    @Query("SELECT new com.warehouse.management.barang.domain.dto.BarangStockData(b.id, b.nama, b.kategori, b.berat, s.stok) FROM Barang b INNER JOIN Stock s oN s.barangId = b.id")
    List<BarangStockData> barangAllWithStock();
}
