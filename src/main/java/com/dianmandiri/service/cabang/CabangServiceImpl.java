package com.dianmandiri.service.cabang;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianmandiri.entity.Cabang;
import com.dianmandiri.entity.Po;
import com.dianmandiri.repository.CabangRepository;

@Service
@Transactional
public class CabangServiceImpl implements CabangService{

	@Autowired
	private CabangRepository cabangRepository;

	@Override
	public List<Cabang> getAllCabang() {
		return (List<Cabang>) cabangRepository.findisactive();

	}

	@Override
	public List<Cabang> findidCabang() {
		return (List<Cabang>) cabangRepository.findTop1ByOrderByIdCabangDesc();
	}

	@Override
	public Cabang save(Cabang cabang) {
		cabang.setStartdt(new Date());
		return cabangRepository.save(cabang);
	}

	@Override
	public Cabang findById(Long idCabang) {
    Optional<Cabang> cabang = cabangRepository.findById(idCabang);
		
		if (cabang.isPresent()) {
			;
			return cabang.get();
		} else {
			System.out.println(cabang);
			return save(null);
		}
	}

	@Override
	public List<Cabang> findAll() {
		
		return null;
	}	
}
