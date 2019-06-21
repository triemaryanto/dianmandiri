package com.dianmandiri.service.kelompok;

import java.util.List;

import com.dianmandiri.entity.HistoryKelompok;

public interface HisKelService {

	HistoryKelompok save(HistoryKelompok hisKel);
	List<HistoryKelompok> inner();
	List<HistoryKelompok> findAll();
}
