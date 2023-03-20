package com.warehouse.management.barang.domain.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long barangId;
    private Long shipperId;
    private Integer stok;
    private String tipe;
    private Date tanggal;
}
