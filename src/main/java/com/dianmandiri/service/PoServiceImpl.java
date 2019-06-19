/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianmandiri.service;

import com.dianmandiri.entity.Po;
import com.dianmandiri.repository.PoRepository;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Temporal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PoServiceImpl implements PoService {
	
	@Autowired
	private PoRepository poRepository;

	@Override
	public List<Po> getAllPo() {
		return (List<Po>) poRepository.findisactive();

	}

	@Override
	public List<Po> getHistoryPo() {
		return (List<Po>) poRepository.findAll();

	}
	
	@Override
	public List<Po> findidPo() {
		return (List<Po>) poRepository.findTop1ByOrderByIdPoDesc();
		}	
	@Override
	public Po save(Po po) {		
		po.setStartdt(new Date());
		System.out.println(po.getIdPo());
		System.out.println(po.getNamaPo());
		System.out.println(po.getAlamatPo());
		System.out.println(po.getIsactive());
		System.out.println(po.getStartdt());
		System.out.println(po.getEnddt());
		return poRepository.save(po);
	}

	@Override
	public Po findById(Long skPo) {
		Optional<Po> po = poRepository.findById(skPo);
		
		if (po.isPresent()) {
			;
			return po.get();
		} else {
			System.out.println(po);
			return save(null);
		}
	}
	@Override
	public Po update(Po po) {		
		po.setStartdt(new Date());
		if (po.getIsactive() == 0 ) {
			po.setEnddt(new Date());
		}
		System.out.println(po.getNamaPo());
		System.out.println(po.getAlamatPo());
		System.out.println(po.getIsactive());
		System.out.println(po.getStartdt());
		System.out.println(po.getEnddt());
		return poRepository.save(po);
	}	   
}
