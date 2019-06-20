package com.dianmandiri.service;

import java.util.List;

import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.entity.KelompokPo;
import com.dianmandiri.entity.Orientasi;

public interface KelompokPoService {

	List<KelompokPo>join();

	KelompokPo save(KelompokPo kelompokPo);

	KelompokPo findById(Long idKelompok);
	
	List<Orientasi>joinOrientasiKelompok();

	Orientasi saveOrientasi(Orientasi orientasi);
}
