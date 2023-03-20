package com.warehouse.management.barang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockShipRequestDTO {
    private Long barangId;
    private Long shipperId;
    private Integer stock;
    private String tipe;
}
