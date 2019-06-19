package com.dianmandiri.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dianmandiri.entity.Cabang;
import com.dianmandiri.entity.HistoryMs;
import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.entity.Orientasi;
import com.dianmandiri.service.cabang.CabangService;
import com.dianmandiri.service.historyms.HistoryMsService;
import com.dianmandiri.service.kelompok.KelompokService;

@Controller
public class KelompokController {

	@Autowired
	private KelompokService keSer;

	@Autowired
	private CabangService caSer;

	@Autowired
	private HistoryMsService historyMsService;

	@GetMapping("/kelompok")
	public String Pos(Model model) {
		List<Kelompok> kelompok = keSer.inner();
		List<Cabang> cab = caSer.getAllCabang();
		model.addAttribute("kelomp", kelompok);
		model.addAttribute("ab", cab);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "Data Kelompok");
		return "kelompok";
	}

	@RequestMapping(value = "/kelompok/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		List<Cabang> cabang = caSer.getAllCabang();
		model.addAttribute("cabang", cabang);
		model.addAttribute("kelompok", new Kelompok());
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "Form Kelompok");
		model.addAttribute("isAdd", true);
		return "form/formKel";
	}

	@RequestMapping(value = "/orientasi/create", method = RequestMethod.GET)
	public String orientasi(Model model) {
		List<Kelompok> kelompok = keSer.getAllKel();
		model.addAttribute("kelompok1", kelompok);
		model.addAttribute("orientasi", new Orientasi());
		model.addAttribute("title", "Orientasi");
		model.addAttribute("h2", "Form Orientasi");
		model.addAttribute("isAdd", true);
		return "form/formOrientasi";
	}

	@PostMapping(value = "savekelo")
	public String saveKelompok(@ModelAttribute Kelompok kelompok, RedirectAttributes redirectAttributes, Model model) {

		Kelompok dbPo = keSer.save(kelompok);

		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/kelompok";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("kelompok", kelompok);
			return "Kelompok";
		}
	}

	@GetMapping(value = "getKelompok/{idKelompok}")
	public String getPo(@PathVariable Long idKelompok, Model model) {
		Kelompok kelompok = keSer.findById(idKelompok);
		List<Cabang> cabang = caSer.getAllCabang();
		model.addAttribute("cabang", cabang);
		model.addAttribute("kelompok", kelompok);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "Edit Data Kelompok");
		model.addAttribute("isAdd", false);
		return "form/formKel";
	}

	@PostMapping(value = "updatekel")
	public String update(@ModelAttribute Kelompok kelompok, HistoryMs historyMs, Cabang cabang,
			RedirectAttributes redirectAttributes, Model model) {
		Kelompok datasebelum = keSer.findById(kelompok.getIdKelompok());
		historyMs.setPage("kelompok");
		historyMs.setIdRelasi(kelompok.getIdKelompok());
		historyMs.setNama(datasebelum.getNamaKelompok());
		historyMs.setIdCabang(kelompok.getIdCabang());
		historyMs.setAlamat(datasebelum.getLokasiPertemuan());
		historyMs.setStatus(kelompok.getStatus());
		historyMs.setIsactive(0);
		historyMs.setStartdt(datasebelum.getStartdt());
		historyMs.setEnddt(new Date());
		historyMsService.save(historyMs);
		Kelompok dbPo = keSer.save(kelompok);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil di update Disimpan");
			return "redirect:/kelompok";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", kelompok);
			return "kelompok";
		}
	}

	@GetMapping("/kelompok/history")
	public String HistoryCabang(Model model) {
		List<HistoryMs> history = historyMsService.findkelompok();
		List<Kelompok> kelompok = keSer.inner();
		model.addAttribute("kelomp", kelompok);
		model.addAttribute("his", history);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "Data Kelompok");
		return "historyKel";

	}

}
