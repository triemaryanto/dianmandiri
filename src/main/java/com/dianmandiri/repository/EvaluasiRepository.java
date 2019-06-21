package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.dianmandiri.entity.Evaluasi;

public interface EvaluasiRepository extends CrudRepository<Evaluasi, Long> {
	@Query("SELECT u, +nama, k.namaKelompok FROM Evaluasi u INNER JOIN u.kelompok k ON u.idKelompok=k.idKelompok WHERE u.isactive = 1")
	public List<Evaluasi> joinEvaluasiKelompok();
}
