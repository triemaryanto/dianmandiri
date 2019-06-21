package com.dianmandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dianmandiri.entity.Cabang;
@Repository
public interface CabangRepository extends CrudRepository<Cabang, Long>{
	@Query("SELECT u FROM Cabang u WHERE u.isactive = 1")
	public List<Cabang> findisactive();	
    public List<Cabang> findTop1ByOrderByIdCabangDesc();
}
