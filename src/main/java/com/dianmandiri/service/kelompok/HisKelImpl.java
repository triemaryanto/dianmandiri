package com.dianmandiri.service.kelompok;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianmandiri.entity.HistoryKelompok;
import com.dianmandiri.repository.HisKelRepository;

@Service
@Transactional
public class HisKelImpl implements HisKelService {

	@Autowired
	private HisKelRepository hiskelrepo;

	@Override
	public HistoryKelompok save(HistoryKelompok hisKel) {
		return hiskelrepo.save(hisKel);
		
	}

	@Override
	public List<HistoryKelompok> inner() {
		return (List<HistoryKelompok>) hiskelrepo.innerjoin();
	}

	@Override
	public List<HistoryKelompok> findAll() {
		return (List<HistoryKelompok>) hiskelrepo.findAll();
	}
	

}