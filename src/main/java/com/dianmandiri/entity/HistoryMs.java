package com.dianmandiri.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "history_ms")
public class HistoryMs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_history")
	Long idHistory;
	String page;
	Long idRelasi;
	String nama;
	String alamat;
	@Column(name = "id_cabang")
	Long idCabang;
	String telepon;
	Integer isactive;
	String status;
	@CreatedDate
	@Column(name = "start_dt")
	@Temporal(TemporalType.TIMESTAMP)
	Date startdt;
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_dt")
	Date enddt;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Long getIdRelasi() {
		return idRelasi;
	}

	public void setIdRelasi(Long idRelasi) {
		this.idRelasi = idRelasi;
	}

	public Long getIdHistory() {
		return idHistory;
	}

	public void setIdHistory(Long idHistory) {
		this.idHistory = idHistory;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}	

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Long getIdCabang() {
		return idCabang;
	}

	public void setIdCabang(Long idCabang) {
		this.idCabang = idCabang;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
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
