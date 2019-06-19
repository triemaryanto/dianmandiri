package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dianmandiri.entity.HistoryMs;

public interface HistoryMsRepository extends CrudRepository<HistoryMs, Long> {
	@Query("SELECT u FROM HistoryMs u WHERE u.page = 'cabang'")
	public List<HistoryMs> findcabang();
	@Query("SELECT hm, +namaCabang FROM  HistoryMs hm INNER JOIN hm.cabang c ON hm.idCabang=c.idCabang WHERE hm.page = 'kelompok'" )
	public List<HistoryMs> findkelompok();
	@Query("SELECT u FROM HistoryMs u WHERE u.page = 'po'")
	public List<HistoryMs> findpo();

}
