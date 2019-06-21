package com.dianmandiri.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianmandiri.entity.Evaluasi;
import com.dianmandiri.entity.KelompokPo;
import com.dianmandiri.entity.Orientasi;
import com.dianmandiri.entity.Realisasi;
import com.dianmandiri.repository.EvaluasiRepository;
import com.dianmandiri.repository.KelompokPoRepository;
import com.dianmandiri.repository.OrientasiRepository;
import com.dianmandiri.repository.RealisasiRepository;

@Service
@Transactional
public class TrServiceImpl implements TrService {
	
	@Autowired
	private KelompokPoRepository kelompokPoRepository;
	@Autowired
	private OrientasiRepository orientasiRepository;
	@Autowired
	private EvaluasiRepository evaluasiRepository;
	@Autowired
	private RealisasiRepository realisasiRepository;

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
	
	@Override
	public Orientasi findByIdOrientasi(Long idOrientasi) {
		Optional<Orientasi> po = orientasiRepository.findById(idOrientasi);

		if (po.isPresent()) {
			;
			return po.get();
		} else {
			return orientasiRepository.save(null);
		}
	}
	/*Evaluasi*/

	@Override
	public List<Evaluasi> joinEvaluasiKelompok() {
		
		return (List<Evaluasi>) evaluasiRepository.joinEvaluasiKelompok();
	}

	@Override
	public Evaluasi saveEvaluasi(Evaluasi evaluasi) {
		evaluasi.setStartdt(new Date());
		return evaluasiRepository.save(evaluasi);
	}

	@Override
	public List<Realisasi> joinRealisasi() {
		// TODO Auto-generated method stub
		return (List<Realisasi>) realisasiRepository.joinRealisasi();
	}

	

	
}
