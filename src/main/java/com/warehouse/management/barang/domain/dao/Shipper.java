package com.warehouse.management.barang.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_shipper")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Nama is required")
    private String nama;

    @NotEmpty(message = "Code Shipper is required")
    private String codeShipper;
}
