package com.dianmandiri.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianmandiri.entity.KelompokPo;
import com.dianmandiri.entity.Orientasi;
import com.dianmandiri.repository.KelompokPoRepository;
import com.dianmandiri.repository.OrientasiRepository;

@Service
@Transactional
public class KelompokPoServiceImpl implements KelompokPoService {

	@Autowired
	private KelompokPoRepository kelompokPoRepository;
	@Autowired
	private OrientasiRepository orientasiRepository;

	@Override
	public List<KelompokPo> join() {

		return (List<KelompokPo>) kelompokPoRepository.join();
	}

	@Override
	public KelompokPo save(KelompokPo kelompokPo) {
		kelompokPo.setStartdt(new Date());
		return kelompokPoRepository.save(kelompokPo);
	}

	@Override
	public KelompokPo findById(Long idKelompok) {
		Optional<KelompokPo> po = kelompokPoRepository.findById(idKelompok);

		if (po.isPresent()) {
			;
			return po.get();
		} else {
			System.out.println(po);
			return save(null);
		}
	}

	/* Orientasi */
	@Override
	public List<Orientasi> joinOrientasiKelompok() {
		return (List<Orientasi>) orientasiRepository.joinOrientasiKelompok();
	}

	@Override
	public Orientasi saveOrientasi(Orientasi orientasi) {
		orientasi.setStartdt(new Date());
		return orientasiRepository.save(orientasi);
	}
}
