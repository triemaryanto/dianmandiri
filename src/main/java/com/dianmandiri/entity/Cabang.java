package com.dianmandiri.entity;

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
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "ms_cabang")

public class Cabang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8290204779690313254L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "id_cabang")
	private Long idCabang;
	@Column(name = "nama_cabang")
	private String namaCabang;
	private String telepon;
	private String alamat;
	private Integer isactive;
	@CreatedDate
	@Column(name = "start_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdt;
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_dt")
	private Date enddt;
	@ManyToMany(targetEntity = Kelompok.class, mappedBy = "idCabang", fetch = FetchType.LAZY)
	
	private Set<Kelompok> kelompok;

	public Cabang() {

	}

	public Long getIdCabang() {
		return idCabang;
	}

	public void setIdCabang(Long idCabang) {
		this.idCabang = idCabang;
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
