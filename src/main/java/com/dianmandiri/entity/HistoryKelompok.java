package com.dianmandiri.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ms_kelompok_history")
public class HistoryKelompok {

	@Id
	@Column (name = "id_kelompok")
	Long idKelompok;
	@Column(name = "id_relasi")
	private Long idRelasi;
	@Column (name = "nama_kelompok")
	String namaKelompok;
	@Column (name="id_cabang")
	Long idCabang;
	@Column (name ="lokasi_pertemuan")
	String lokasiPertemuan;
	String status;
	Integer isactive;
	@CreatedDate
    @Column(name = "start_dt")
    @Temporal(TemporalType.TIMESTAMP)
    Date startdt;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_dt")
    Date enddt; 
    String namaCabang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cabang", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Cabang cabang;
   
   
	public Long getIdCabang() {
		return idCabang;
	}
	public void setIdCabang(Long idCabang) {
		this.idCabang = idCabang;
	}
	public Long getIdKelompok() {
		return idKelompok;
	}
	public void setIdKelompok(Long idKelompok) {
		this.idKelompok = idKelompok;
	}
	public String getNamaKelompok() {
		return namaKelompok;
	}
	public void setNamaKelompok(String namaKelompok) {
		this.namaKelompok = namaKelompok;
	}	
	public String getLokasiPertemuan() {
		return lokasiPertemuan;
	}
	public void setLokasiPertemuan(String lokasiPertemuan) {
		this.lokasiPertemuan = lokasiPertemuan;
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
	public String getNamaCabang() {
		return namaCabang=cabang.getNamaCabang();
	}
	public void setNamaCabang(String namaCabang) {
		this.namaCabang = namaCabang;
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
	public Long getIdRelasi() {
		return idRelasi;
	}
	public void setIdRelasi(Long idRelasi) {
		this.idRelasi = idRelasi;
	}
	
}
