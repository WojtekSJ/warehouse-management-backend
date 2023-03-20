package com.warehouse.management.barang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarangStockData {
    private Long id;

    private String nama;

    private String kategori;

    private Integer berat;

    private Integer stok;

}
