package com.dianmandiri.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dianmandiri.entity.HistoryPo;
import com.dianmandiri.repository.HistoryRepository;

@Service
@Transactional
public class HistoryImpl implements HistoryService {

	@Autowired
	private HistoryRepository hisRepository;	
	
	@Override
	public HistoryPo save(HistoryPo po) {		
		po.setStartdt(new Date());
		return hisRepository.save(po);
	}
	@Override
	public List<HistoryPo> getHistoryPo() {
		
		return (List<HistoryPo>)hisRepository.findpo();
	}	
}
