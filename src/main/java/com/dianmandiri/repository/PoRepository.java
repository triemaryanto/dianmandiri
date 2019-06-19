/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianmandiri.repository;

import com.dianmandiri.entity.Po;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoRepository extends CrudRepository<Po, Long> {
	@Query("SELECT u FROM Po u WHERE u.isactive = 1")
	public List<Po> findisactive();	
    public List<Po> findTop1ByOrderByIdPoDesc();	
	
}
