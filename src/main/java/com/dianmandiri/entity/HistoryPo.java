package com.dianmandiri.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "ms_history_po")
public class HistoryPo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_History")
	private Long idHistory;
	@Column(name = "id_relasi")
	private Long idRelasi;
	private String entity;
	@Column(name = "nama_po")
	private String namaPo;
	@Column(name = "alamat_po")
	private String alamatPo;
	@Column(columnDefinition = "TEXT")
	private String keterangan;
	private Integer isactive;
	@CreatedDate
	@Temporal(TIMESTAMP)
	@Column(name = "start_dt")
	private Date startdt;
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	@Column(name = "end_dt")
	private Date enddt;

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public Long getIdRelasi() {
		return idRelasi;
	}

	public void setIdRelasi(Long idRelasi) {
		this.idRelasi = idRelasi;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
	public Long getIdHistory() {
		return idHistory;
	}

	public void setIdHistory(Long idHistory) {
		this.idHistory = idHistory;
	}

	public String getNamaPo() {
		return namaPo;
	}

	public void setNamaPo(String namaPo) {
		this.namaPo = namaPo;
	}

	public String getAlamatPo() {
		return alamatPo;
	}

	public void setAlamatPo(String alamatPo) {
		this.alamatPo = alamatPo;
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
