package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dianmandiri.entity.HistoryPo;
@Repository
public interface HistoryRepository extends CrudRepository<HistoryPo, Long>{

	@Query("SELECT u FROM HistoryPo u WHERE u.entity ='po'")
	public List<HistoryPo> findpo();	
	

}
 