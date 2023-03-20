package com.warehouse.management.barang.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_barang")
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Nama is required.")
    private String nama;

    @NotEmpty(message = "Kategori is required.")
    private String kategori;

    @NotNull(message = "Berat is required.")
    @Min(value = 1, message = "Berat must be greater than 0")
    private Integer berat;
}
