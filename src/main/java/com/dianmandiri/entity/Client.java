package com.dianmandiri.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ms_client")
public class Client {

	@Id
	@GeneratedValue (strategy =  GenerationType.AUTO)
	@Column (name = "id_client")
	Long idClient;
	@Column (name = "nama_client")
	String namaClient;
	@Column (name = "jenis_kelamin")
	String jenisKelamin;
	@Column (name = "no_ktp")
	Integer noKtp;
	String alamat;
	@Column (name = "tanggal_lahir")
	Date tgl;
	String pendidikan;
	@Column (name = "jumlah_tanggungan")
	Integer jumlahTanggungan;
	@Column (name = "jenis_usaha")
	String jenisUsaha;
	@Column (name = "lokasi_usaha")
	String lokasiUsaha;
	@Column (name = "lama_usaha")
	String lamaUsaha;
	@Column (name = "kepemilikan_usaha")
	String kepemilikanUsaha;
	@Column (name = "omset_mingguan")
	Integer omsetMingguan;
	@Column (name = "modal_mingguan")
	Integer modalMingguan;
	@Column (name = "laba_bersih_mingguan")
	Integer labaBersihMingguan;
	@Column (name = "jml_tenaga_kerja")
	Integer jmlTenagaKerja;
	@Column (name = "upah_tenaga_kerja")
	Integer upahTenagaKerja;
	@Column (name = "pendapatan_keluarga")
	Integer pendapatanKeluarga;
	@Column (name = "modal_kerja")
	Integer modalKerja;
	@Column (name = "jumlah_pinjaman_lain")
	Integer jumlahPinjamanLain;
	@Column (name = "pemberi_pinjaman_lain")
	Integer pemberiPinjamanLain;
	@Column (name = "pengeluaran_keluarga_mingguan")
	Integer pengeluaranKeluargaMingguan;
	@Column (name = "kesehatan_keluarga")
	String kesehatanKeluarga;
	@Column (name = "nama_penanggung")
	String namaPenanggung;
	@Column (name = "hub_penanggung")
	String hubPenanggung;
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNamaClient() {
		return namaClient;
	}
	public void setNamaClient(String namaClient) {
		this.namaClient = namaClient;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public Integer getNoKtp() {
		return noKtp;
	}
	public void setNoKtp(Integer noKtp) {
		this.noKtp = noKtp;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public Date getTgl() {
		return tgl;
	}
	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}
	public String getPendidikan() {
		return pendidikan;
	}
	public void setPendidikan(String pendidikan) {
		this.pendidikan = pendidikan;
	}
	public Integer getJumlahTanggungan() {
		return jumlahTanggungan;
	}
	public void setJumlahTanggungan(Integer jumlahTanggungan) {
		this.jumlahTanggungan = jumlahTanggungan;
	}
	public String getJenisUsaha() {
		return jenisUsaha;
	}
	public void setJenisUsaha(String jenisUsaha) {
		this.jenisUsaha = jenisUsaha;
	}
	public String getLokasiUsaha() {
		return lokasiUsaha;
	}
	public void setLokasiUsaha(String lokasiUsaha) {
		this.lokasiUsaha = lokasiUsaha;
	}
	public String getLamaUsaha() {
		return lamaUsaha;
	}
	public void setLamaUsaha(String lamaUsaha) {
		this.lamaUsaha = lamaUsaha;
	}
	public String getKepemilikanUsaha() {
		return kepemilikanUsaha;
	}
	public void setKepemilikanUsaha(String kepemilikanUsaha) {
		this.kepemilikanUsaha = kepemilikanUsaha;
	}
	public Integer getOmsetMingguan() {
		return omsetMingguan;
	}
	public void setOmsetMingguan(Integer omsetMingguan) {
		this.omsetMingguan = omsetMingguan;
	}
	public Integer getModalMingguan() {
		return modalMingguan;
	}
	public void setModalMingguan(Integer modalMingguan) {
		this.modalMingguan = modalMingguan;
	}
	public Integer getLabaBersihMingguan() {
		return labaBersihMingguan;
	}
	public void setLabaBersihMingguan(Integer labaBersihMingguan) {
		this.labaBersihMingguan = labaBersihMingguan;
	}
	public Integer getJmlTenagaKerja() {
		return jmlTenagaKerja;
	}
	public void setJmlTenagaKerja(Integer jmlTenagaKerja) {
		this.jmlTenagaKerja = jmlTenagaKerja;
	}
	public Integer getUpahTenagaKerja() {
		return upahTenagaKerja;
	}
	public void setUpahTenagaKerja(Integer upahTenagaKerja) {
		this.upahTenagaKerja = upahTenagaKerja;
	}
	public Integer getPendapatanKeluarga() {
		return pendapatanKeluarga;
	}
	public void setPendapatanKeluarga(Integer pendapatanKeluarga) {
		this.pendapatanKeluarga = pendapatanKeluarga;
	}
	public Integer getModalKerja() {
		return modalKerja;
	}
	public void setModalKerja(Integer modalKerja) {
		this.modalKerja = modalKerja;
	}
	public Integer getJumlahPinjamanLain() {
		return jumlahPinjamanLain;
	}
	public void setJumlahPinjamanLain(Integer jumlahPinjamanLain) {
		this.jumlahPinjamanLain = jumlahPinjamanLain;
	}
	public Integer getPemberiPinjamanLain() {
		return pemberiPinjamanLain;
	}
	public void setPemberiPinjamanLain(Integer pemberiPinjamanLain) {
		this.pemberiPinjamanLain = pemberiPinjamanLain;
	}
	public Integer getPengeluaranKeluargaMingguan() {
		return pengeluaranKeluargaMingguan;
	}
	public void setPengeluaranKeluargaMingguan(Integer pengeluaranKeluargaMingguan) {
		this.pengeluaranKeluargaMingguan = pengeluaranKeluargaMingguan;
	}
	public String getKesehatanKeluarga() {
		return kesehatanKeluarga;
	}
	public void setKesehatanKeluarga(String kesehatanKeluarga) {
		this.kesehatanKeluarga = kesehatanKeluarga;
	}
	public String getNamaPenanggung() {
		return namaPenanggung;
	}
	public void setNamaPenanggung(String namaPenanggung) {
		this.namaPenanggung = namaPenanggung;
	}
	public String getHubPenanggung() {
		return hubPenanggung;
	}
	public void setHubPenanggung(String hubPenanggung) {
		this.hubPenanggung = hubPenanggung;
	}
}
