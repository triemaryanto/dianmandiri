/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianmandiri.entity;

import static javax.persistence.TemporalType.TIMESTAMP;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "ms_po")
public class Po implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3876803936106284666L;
	@Id
	@GeneratedValue (strategy =  GenerationType.AUTO)
	@Column(name = "id_po")
	private Long idPo;
	@Column(name = "nama_po")
	private String namaPo;
	@Column(name = "alamat_po")
	private String alamatPo;
	private Integer isactive;
	@CreatedDate
	@Temporal(TIMESTAMP)
	@Column(name = "start_dt")
	private Date startdt;
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	@Column(name = "end_dt")
	private Date enddt;

	@ManyToMany(targetEntity = KelompokPo.class, mappedBy = "idPo", fetch = FetchType.LAZY)

	private Set<KelompokPo> kelompokPo;

	public Po() {

	}
	public Long getIdPo() {
		return idPo;
	}

	/**
	 * @param idPo the idPo to set
	 */
	public void setIdPo(Long idPo) {
		this.idPo = idPo;
	}

	/**
	 * @return the namaPo
	 */
	public String getNamaPo() {
		return namaPo;
	}

	/**
	 * @param namaPo the namaPo to set
	 */
	public void setNamaPo(String namaPo) {
		this.namaPo = namaPo;
	}

	/**
	 * @return the alamatPo
	 */
	public String getAlamatPo() {
		return alamatPo;
	}

	/**
	 * @param alamatPo the alamatPo to set
	 */
	public void setAlamatPo(String alamatPo) {
		this.alamatPo = alamatPo;
	}

	/**
	 * @return the isactive
	 */
	public Integer getIsactive() {
		return isactive;
	}

	/**
	 * @param isactive the isactive to set
	 */
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	/**
	 * @return the startdt
	 */
	public Date getStartdt() {
		return startdt;
	}

	/**
	 * @param the startdt to set
	 */
	public void setStartdt(Date startdt) {

		this.startdt = startdt;
	}

	/**
	 * @return the enddt
	 */
	public Date getEnddt() {
		return enddt;
	}

	/**
	 * @param enddt the enddt to set
	 */
	public void setEnddt(Date enddt) {
		this.enddt = enddt;
	}	
}
