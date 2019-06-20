package com.dianmandiri.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.dianmandiri.entity.KelompokPo;
import com.dianmandiri.entity.Orientasi;
import com.dianmandiri.entity.Po;
import com.dianmandiri.service.KelompokPoService;
import com.dianmandiri.service.PoService;
import com.dianmandiri.service.kelompok.KelompokService;

@Controller
public class TrController {

	private static final String Orientasi = null;
	@Autowired
	private PoService poService;
	@Autowired
	private KelompokService keSer;
	@Autowired
	private KelompokPoService kelompokPoService;
	
	/* crud tr_kelompok_po*/
	@GetMapping("/kelompokpo")
	public String tableKelPo(Model model) {
		List<KelompokPo> kelompokPo = kelompokPoService.join();
		model.addAttribute("post", kelompokPo);
		Logger logger = LoggerFactory.getLogger(TrController.class);
		logger.info("ini"+kelompokPo);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "Data Kelompok");
		return "kelompok_po";
	} 
	@PostMapping(value = "savekelpo")
	public String saveKelPo(@ModelAttribute KelompokPo kelompokPo, RedirectAttributes redirectAttributes, Model model) {
		
		KelompokPo dbPo = kelompokPoService.save(kelompokPo);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/kelompokpo";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", kelompokPo);
			return "kelompokpo";
		}
	}
	
	@RequestMapping(value = "/kelompokpo/create", method = RequestMethod.GET)
	public String tampilkan(Model model) {
		List<Kelompok> kelompok = keSer.getAllKel();
		List<Po> po = poService.getAllPo();
		model.addAttribute("po", po);
		model.addAttribute("kelompok1", kelompok);
		model.addAttribute("kelompokpo", new KelompokPo());
		model.addAttribute("title", "Form Kelompok");
		model.addAttribute("h2", "tr_kelompok_po");
		model.addAttribute("isAdd", true);
		return "form/formKelPo";
	}
	@GetMapping(value = "getKelompokPo/{idKelompok}")
	public String getPo(@PathVariable Long idKelompok, Model model) {
		KelompokPo kelompokPo = kelompokPoService.findById(idKelompok);
		List<Kelompok> kelompok = keSer.getAllKel();
		List<Po> po = poService.getAllPo();
		model.addAttribute("po", po);
		model.addAttribute("kelompok1", kelompok);
		model.addAttribute("kelompokPo", kelompokPo);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "Edit Data Kelompok");
		model.addAttribute("isAdd", false);
		return "form/formKelPo";
	}
	@PostMapping(value = "updatekelpo")
	public String update(@ModelAttribute KelompokPo kelompokPo,	RedirectAttributes redirectAttributes, Model model) {
		KelompokPo dbPo = kelompokPoService.save(kelompokPo);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/kelompokpo";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", kelompokPo);
			return "kelompokpo";
		}
	}
	/*end*/
	/*tr_orientasi*/
	@GetMapping("/orientasi")
	public String tableorientasi(Model model) {
		List<Orientasi> orientasi = kelompokPoService.joinOrientasiKelompok();
		model.addAttribute("orientasi", orientasi);
		Logger logger = LoggerFactory.getLogger(TrController.class);
		logger.info("data"+orientasi);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "Data Kelompok");
		return "orientasi";
	} 
	
	@RequestMapping(value = "/orientasi/create", method = RequestMethod.GET)
	public String formOrientasi(Model model) {
		List<Kelompok> kelompok = keSer.getAllKel();
		model.addAttribute("kelompok", kelompok);
		model.addAttribute("orientasi", new Orientasi());
		model.addAttribute("h2", "Orientasi");
		model.addAttribute("isAdd", true);
		return "form/formOrientasi";
	}
	
	@PostMapping(value = "saveorientasi")
	public String saveOrientai(@ModelAttribute Orientasi orientasi, RedirectAttributes redirectAttributes, Model model) {
		Orientasi dbPo = kelompokPoService.saveOrientasi(orientasi);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/orientasi";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", orientasi);
			return "orientasi";
		}
	}
	
	
	/*end*/
	
}
