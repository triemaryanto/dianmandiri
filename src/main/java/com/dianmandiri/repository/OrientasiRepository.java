package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.entity.Orientasi;

public interface OrientasiRepository extends CrudRepository<Orientasi, Long> {
	@Query("SELECT u, +nama, k.namaKelompok FROM Orientasi u INNER JOIN u.kelompok k ON u.idKelompok=k.idKelompok WHERE u.isactive = 1")
	public List<Orientasi> joinOrientasiKelompok();

}
