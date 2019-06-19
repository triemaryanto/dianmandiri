package com.dianmandiri.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.entity.KelompokPo;
import com.dianmandiri.entity.Po;
import com.dianmandiri.repository.KelompokPoRepository;

@Service
@Transactional
public class KelompokPoServiceImpl implements KelompokPoService{

	@Autowired
	private KelompokPoRepository kelompokPoRepository;

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

	
	
	
}
