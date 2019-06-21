package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dianmandiri.entity.HistoryKelompok;

@Repository
public interface HisKelRepository extends CrudRepository<HistoryKelompok, Long>{

	
	@Query("SELECT  k, +namaKelompok, c.namaCabang FROM  HistoryKelompok k INNER JOIN k.cabang c ON k.idCabang=c.idCabang")
	public List<HistoryKelompok> innerjoin();
	
}
