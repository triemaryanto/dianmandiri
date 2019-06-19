/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianmandiri.service;
import java.util.List;
import com.dianmandiri.entity.Po;
public interface PoService {	
	List<Po> getAllPo();
	List<Po> findidPo();
	List<Po> getHistoryPo();
	Po save(Po po);
	Po findById(Long idPo);
	Po update(Po po);
		
}