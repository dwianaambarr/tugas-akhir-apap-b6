package com.apap.finalprojectB6.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apap.finalprojectB6.model.JenisModel;

public interface JenisDB extends JpaRepository<JenisModel, Integer>{
	JenisModel findById(int id);
	void deleteById(int id);
	
	@Query(value = "SELECT * FROM user_profile WHERE nama = ?1", nativeQuery = true)
	public ArrayList<JenisModel> validate(String nama);
}
