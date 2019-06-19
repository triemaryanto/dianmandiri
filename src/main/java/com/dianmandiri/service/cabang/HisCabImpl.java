package com.dianmandiri.service.cabang;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianmandiri.entity.HistoryCabang;
import com.dianmandiri.repository.HisCabRepository;

@Service
@Transactional
public class HisCabImpl implements HisCabService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private HisCabRepository hisRepo;	
	
	

	@Override
	public HistoryCabang save(HistoryCabang history) {		
		return hisRepo.save(history);
	}

	@Override
	public List<HistoryCabang> getHistoryCabang() {
		return (List<HistoryCabang>) hisRepo.findAll();
	}
}
