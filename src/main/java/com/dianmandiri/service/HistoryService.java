package com.dianmandiri.service;

import java.util.List;

import com.dianmandiri.entity.HistoryPo;

public interface HistoryService {
	HistoryPo save(HistoryPo history);
	List<HistoryPo> getHistoryPo();
}
