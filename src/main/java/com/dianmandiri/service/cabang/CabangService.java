package com.dianmandiri.service.cabang;

import java.util.List;

import com.dianmandiri.entity.Cabang;

public interface CabangService {
	List<Cabang> getAllCabang();
	List<Cabang> findidCabang();
	Cabang save(Cabang cabang);
	Cabang findById(Long idCabang);
	List<Cabang> findAll();
}
