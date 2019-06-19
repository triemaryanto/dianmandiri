package com.dianmandiri.service.historyms;


import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dianmandiri.entity.HistoryMs;
import com.dianmandiri.entity.HistoryPo;
import com.dianmandiri.repository.HistoryMsRepository;

@Service
@Transactional
public class HistoryMsImpl implements HistoryMsService {

	@Autowired
	private HistoryMsRepository historyMsRepository;
	
	@Override
	public HistoryMs save(HistoryMs ms) {	
		return historyMsRepository.save(ms);
	}

	@Override
	public List<HistoryMs> getHistoryCabang() {
		return (List<HistoryMs>)historyMsRepository.findcabang();
	}

	@Override
	public List<HistoryMs> findpo() {
		return (List<HistoryMs>)historyMsRepository.findpo();
	}

	@Override
	public List<HistoryMs> findkelompok() {
		return (List<HistoryMs>)historyMsRepository.findkelompok();
	}
	
}
