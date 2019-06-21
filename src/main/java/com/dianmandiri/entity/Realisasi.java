package com.dianmandiri.entity;

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
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "tr_realisasi")
public class Realisasi implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_realisasi")
	private Long idRealisasi;
	@Column(name = "id_kelompok")
	private Long idKelompok;
	Integer Periode;
	@Column(name = "hari_pembayaran")
	String hariPembayaran;
	@Column(name = "jatuh_tempo")
	private Date jatuhTempo;
	@Column(name = "jumlah_budget")
	private Integer jumlahBudget;
	@Column(name = "jumlah_realisasi")
	private Integer jumlahRealisasi;
	@Column(name = "alasan_persetujuan")
	String alasanPersetujuan;
	String status;
	Integer isactive;
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
		return namaKelompok = kelompok.getNamaKelompok();
	}

	public void setNamaKelompok(String namaKelompok) {
		this.namaKelompok = namaKelompok;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_kelompok", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Kelompok kelompok;

	public Long getIdRealisasi() {
		return idRealisasi;
	}

	public void setIdRealisasi(Long idRealisasi) {
		this.idRealisasi = idRealisasi;
	}

	public Long getIdKelompok() {
		return idKelompok;
	}

	public void setIdKelompok(Long idKelompok) {
		this.idKelompok = idKelompok;
	}

	public Integer getPeriode() {
		return Periode;
	}

	public void setPeriode(Integer periode) {
		Periode = periode;
	}

	public String getHariPembayaran() {
		return hariPembayaran;
	}

	public void setHariPembayaran(String hariPembayaran) {
		this.hariPembayaran = hariPembayaran;
	}

	public Date getJatuhTempo() {
		return jatuhTempo;
	}

	public void setJatuhTempo(Date jatuhTempo) {
		this.jatuhTempo = jatuhTempo;
	}

	public Integer getJumlahBudget() {
		return jumlahBudget;
	}

	public void setJumlahBudget(Integer jumlahBudget) {
		this.jumlahBudget = jumlahBudget;
	}

	public Integer getJumlahRealisasi() {
		return jumlahRealisasi;
	}

	public void setJumlahRealisasi(Integer jumlahRealisasi) {
		this.jumlahRealisasi = jumlahRealisasi;
	}

	public String getAlasanPersetujuan() {
		return alasanPersetujuan;
	}

	public void setAlasanPersetujuan(String alasanPersetujuan) {
		this.alasanPersetujuan = alasanPersetujuan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
