package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.PeminjamanModel;


public interface PeminjamanService {
	void addPeminjaman(PeminjamanModel pinjam);
	List<PeminjamanModel> getAllPeminjaman();
	PeminjamanModel getPeminjamanById(int id);
	PeminjamanModel getPeminjamanByStatus(int status);
	void updatePeminjaman(int id, PeminjamanModel pinjam);
	void deletePeminjaman(int id);
	void hitungHari(int id, PeminjamanModel buku);
	

}
