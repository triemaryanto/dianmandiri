package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dianmandiri.entity.HistoryCabang;
import com.dianmandiri.entity.HistoryPo;

@Repository
public interface HisCabRepository extends CrudRepository<HistoryCabang, Long>{

	
}
