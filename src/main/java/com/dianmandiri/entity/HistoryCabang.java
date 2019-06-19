package com.dianmandiri.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ms_history_cabang")
public class HistoryCabang {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_cabang") 
    private Long idCabang;       
	@Column(name = "id_relasi")
	private Long idRelasi;
    @Column(name = "nama_cabang")
    private String namaCabang;
    @Column(name = "telepon")
    private String telepon;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "isactive")
    private Integer isactive;    
    @CreatedDate
    @Column(name = "start_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdt;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_dt")
    private Date enddt;
    public Long getIdCabang() {
		return idCabang;
	}
	public void setIdCabang(Long idCabang) {
		this.idCabang = idCabang;
	}
	public Long getIdRelasi() {
		return idRelasi;
	}
	public void setIdRelasi(Long idRelasi) {
		this.idRelasi = idRelasi;
	}
	public String getNamaCabang() {
		return namaCabang;
	}
	public void setNamaCabang(String namaCabang) {
		this.namaCabang = namaCabang;
	}
	public String getTelepon() {
		return telepon;
	}
	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
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
