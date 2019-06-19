package com.dianmandiri.service.kelompok;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianmandiri.entity.Cabang;
import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.repository.CabangRepository;
import com.dianmandiri.repository.KelompokRepository;

@Service
@Transactional
public class KelompokServiceImpl implements KelompokService {
	String namaCabang;
	private Cabang cabang;
    
	@Autowired
	private KelompokRepository kelompokRepository;
	@Autowired
	private CabangRepository cabRepo;

	

	@Override
	public List<Cabang> listCabang() {
		return (List<Cabang>) cabRepo.findAll();
	}

	@Override
	public List<Kelompok> findidKelompok() {
		return (List<Kelompok>) kelompokRepository.findTop1ByOrderByIdKelompokDesc();
	}

	@Override
	public Kelompok save(Kelompok kelompok) {
		kelompok.setStartdt(new Date());
		return kelompokRepository.save(kelompok);
	}

	@Override
	public Kelompok findById(Long idKelompok) {
		Optional<Kelompok> kelompok = kelompokRepository.findById(idKelompok);

		if (kelompok.isPresent()) {
			;
			return kelompok.get();
		} else {
			return save(null);
		}

	}

	@Override
	public List<Kelompok> inner() {
	
		return (List<Kelompok>) kelompokRepository.innerjoin();
		
	}

	@Override
	public List<Kelompok> getAllKel() {
		return (List<Kelompok>) kelompokRepository.findAll();
	}

}
