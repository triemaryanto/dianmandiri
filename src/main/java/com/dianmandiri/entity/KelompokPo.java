package com.dianmandiri.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "tr_kelompok_po")
public class KelompokPo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4979796539926725828L;
	@Id
	@Column(name = "id_kelompok")
	Long idKelompok;
	@Column(name = "id_po")
	Long idPo;
	Integer isactive;
	@CreatedDate
	@Temporal(TIMESTAMP)
	@Column(name = "start_dt")
	Date startdt;
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	@Column(name = "end_dt")
	Date enddt;
	String namaKelompok;

	public String getNamaKelompok() {
		return namaKelompok=kelompok.getNamaKelompok();
	}

	public void setNamaKelompok(String namaKelompok) {
		this.namaKelompok = namaKelompok;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_kelompok", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Kelompok kelompok;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_po", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Po po;
	String namaPo;
	public String getNamaPo() {
		return namaPo=po.getNamaPo();
	}

	public void setNamaPo(String namaPo) {
		this.namaPo = namaPo;
	}

	public Long getIdKelompok() {
		return idKelompok;
	}

	public void setIdKelompok(Long idKelompok) {
		this.idKelompok = idKelompok;
	}

	public Long getIdPo() {
		return idPo;
	}

	public void setIdPo(Long idPo) {
		this.idPo = idPo;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public Date getStartdt() {
		return startdt;
	}

	public void setStartdt(Date startdt) {
		this.startdt = startdt;
	}

	public Date getEnddt() {
		return enddt;
	}

	public void setEnddt(Date enddt) {
		this.enddt = enddt;
	}

}
