package com.dianmandiri.service.historyms;

import java.util.List;

import com.dianmandiri.entity.HistoryMs;
import com.dianmandiri.entity.HistoryPo;

public interface HistoryMsService {

	HistoryMs save(HistoryMs ms);

	List<HistoryMs> getHistoryCabang();
	List<HistoryMs> findpo();
	List<HistoryMs> findkelompok();
}
