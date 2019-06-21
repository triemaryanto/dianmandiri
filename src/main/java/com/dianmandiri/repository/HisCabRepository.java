package com.dianmandiri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dianmandiri.entity.HistoryCabang;
@Repository
public interface HisCabRepository extends CrudRepository<HistoryCabang, Long>{

	
}
