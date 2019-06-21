package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.dianmandiri.entity.Realisasi;

public interface RealisasiRepository extends CrudRepository<Realisasi, Long> {
	@Query("SELECT u, +nama, k.namaKelompok FROM Realisasi u INNER JOIN u.kelompok k ON u.idKelompok=k.idKelompok WHERE u.isactive = 1")
	public List<Realisasi> joinRealisasi();
}
