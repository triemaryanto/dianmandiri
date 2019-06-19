package com.dianmandiri.service.kelompok;

import java.util.List;

import com.dianmandiri.entity.HistoryKelompok;
import com.dianmandiri.entity.Kelompok;

public interface HisKelService {

	HistoryKelompok save(HistoryKelompok hisKel);
	List<HistoryKelompok> inner();
	List<HistoryKelompok> findAll();
}
