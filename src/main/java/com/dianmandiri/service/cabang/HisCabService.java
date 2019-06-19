package com.dianmandiri.service.cabang;

import java.util.List;

import com.dianmandiri.entity.HistoryCabang;

public interface HisCabService {

	HistoryCabang save(HistoryCabang history);

	List<HistoryCabang> getHistoryCabang();

}
