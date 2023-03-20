package com.warehouse.management.barang.repository;

import com.warehouse.management.barang.domain.dao.Ship;
import com.warehouse.management.barang.domain.dto.ShippingTrackData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findByBarangId(Long id);

    List<Ship> findByShipperId(Long id);

    @Query(value = "SELECT new com.warehouse.management.barang.domain.dto.ShippingTrackData(b.nama, s.stok, s.tanggal, s.tipe) FROM Ship s INNER JOIN Barang b ON b.id = s.barangId WHERE s.shipperId = :id ")
    List<ShippingTrackData> findByTrackShipper(Long id);
}
