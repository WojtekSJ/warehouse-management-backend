package com.warehouse.management.barang.repository;

import com.warehouse.management.barang.domain.dao.Stock;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, Long> {

    public void deleteByBarangId(Long id);

    public Optional<Stock> findByBarangId(Long id);
}
