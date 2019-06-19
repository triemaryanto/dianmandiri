package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dianmandiri.entity.Kelompok;

@Repository
public interface KelompokRepository extends CrudRepository<Kelompok, Long>{


	public List<Kelompok> findTop1ByOrderByIdKelompokDesc();
	
	@Query("SELECT  k, +namaKelompok, c.namaCabang FROM  Kelompok k INNER JOIN k.cabang c ON k.idCabang=c.idCabang where k.isactive = 1")
	public List<Kelompok> innerjoin();
}
