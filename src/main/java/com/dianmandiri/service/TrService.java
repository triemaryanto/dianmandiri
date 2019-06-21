package com.dianmandiri.service;

import java.util.List;

import com.dianmandiri.entity.Evaluasi;
import com.dianmandiri.entity.KelompokPo;
import com.dianmandiri.entity.Orientasi;
import com.dianmandiri.entity.Realisasi;

public interface TrService {

	List<KelompokPo>join();

	KelompokPo save(KelompokPo kelompokPo);

	KelompokPo findById(Long idKelompok);
	
	/*Orientasi*/
	
	List<Orientasi>joinOrientasiKelompok();
	
	Orientasi saveOrientasi(Orientasi orientasi);	
	
	Orientasi findByIdOrientasi(Long idOrientasi);
	
	/*Evaluasi*/
	List<Evaluasi>joinEvaluasiKelompok();

	Evaluasi saveEvaluasi(Evaluasi evaluasi);

	List<Realisasi> joinRealisasi();

	
}
