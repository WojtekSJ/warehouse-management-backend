package com.warehouse.management.barang;

import com.warehouse.management.barang.constant.TipeBarangConstant;
import com.warehouse.management.barang.domain.dao.Barang;
import com.warehouse.management.barang.domain.dao.Stock;
import com.warehouse.management.barang.repository.BarangRepository;
import com.warehouse.management.barang.repository.StockRepository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BarangApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarangApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(BarangRepository barangRepository, StockRepository stockRepository) {
//		return (args) -> {
//			Barang barang1 = Barang.builder()
//					.id(1l)
//					.nama("Pakaian Anak")
//					.berat(1)
//					.kategori(TipeBarangConstant.TIPE_PAKAIAN)
//					.build();
//
//			Barang barang2 = Barang.builder()
//					.id(2l)
//					.nama("Setrika")
//					.berat(2)
//					.kategori(TipeBarangConstant.TIPE_ELEKTRONIK)
//					.build();
//
//			Stock stock1 = Stock.builder()
//					.barangId(1l)
//					.stok(0)
//					.build();
//
//			Stock stock2 = Stock.builder()
//					.barangId(2l)
//					.stok(0)
//					.build();
//
//			barangRepository.saveAll(List.of(barang1, barang2));
//			stockRepository.saveAll(List.of(stock1, stock2));
//
//		};
//	}
}
