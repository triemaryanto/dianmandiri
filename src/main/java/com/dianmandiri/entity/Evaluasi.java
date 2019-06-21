package com.dianmandiri.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "tr_evaluasi")
public class Evaluasi implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_evaluasi")
	private Long idEvaluasi;
	@Column(name = "id_kelompok")
	private Long idKelompok;
	private String keterangan;
	private String hasil;
	private Integer isactive;
	@CreatedDate
	@Column(name = "start_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdt;
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_dt")
	private Date enddt;
	String namaKelompok;
	
	public String getNamaKelompok() {
		return namaKelompok=kelompok.getNamaKelompok();
	}
	public void setNamaKelompok(String namaKelompok) {
		this.namaKelompok = namaKelompok;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_kelompok", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Kelompok kelompok;
	
	public Long getIdEvaluasi() {
		return idEvaluasi;
	}
	public void setIdEvaluasi(Long idEvaluasi) {
		this.idEvaluasi = idEvaluasi;
	}
	public Long getIdKelompok() {
		return idKelompok;
	}
	public void setIdKelompok(Long idKelompok) {
		this.idKelompok = idKelompok;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getHasil() {
		return hasil;
	}
	public void setHasil(String hasil) {
		this.hasil = hasil;
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
