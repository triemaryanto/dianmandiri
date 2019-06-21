package com.dianmandiri.service.historyms;

import java.util.List;

import com.dianmandiri.entity.HistoryMs;

public interface HistoryMsService {

	HistoryMs save(HistoryMs ms);

	List<HistoryMs> getHistoryCabang();
	List<HistoryMs> findpo();
	List<HistoryMs> findkelompok();
}
