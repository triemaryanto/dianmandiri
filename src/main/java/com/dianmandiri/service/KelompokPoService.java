package com.dianmandiri.service;

import java.util.List;

import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.entity.KelompokPo;

public interface KelompokPoService {

	List<KelompokPo>join();

	KelompokPo save(KelompokPo kelompokPo);

	KelompokPo findById(Long idKelompok);
}
