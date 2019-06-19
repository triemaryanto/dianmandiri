package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dianmandiri.entity.Cabang;
import com.dianmandiri.entity.KelompokPo;
@Repository
public interface KelompokPoRepository extends CrudRepository<KelompokPo, Long>{

	@Query("SELECT kp, +namaKelompok, p.namaPo FROM KelompokPo kp INNER JOIN kp.kelompok k ON kp.idKelompok=k.idKelompok INNER JOIN kp.po p ON kp.idPo = p.idPo  where k.isactive = 1")
	public List<KelompokPo> join();
}
