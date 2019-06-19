package com.dianmandiri.service.kelompok;

import java.util.List;

import com.dianmandiri.entity.Cabang;
import com.dianmandiri.entity.Kelompok;

public interface KelompokService {
	List <Cabang> listCabang();
	List<Kelompok> findidKelompok();
	Kelompok save(Kelompok kelompok);
	Kelompok findById(Long idKelompok);	
	List<Kelompok> inner();
	List<Kelompok> getAllKel();
}
