package com.dianmandiri.controller;

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

import com.dianmandiri.entity.Evaluasi;
import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.entity.KelompokPo;
import com.dianmandiri.entity.Orientasi;
import com.dianmandiri.entity.Po;
import com.dianmandiri.entity.Realisasi;
import com.dianmandiri.service.TrService;
import com.dianmandiri.service.PoService;
import com.dianmandiri.service.kelompok.KelompokService;

@Controller
public class TrController {

	@Autowired
	private PoService poService;
	@Autowired
	private KelompokService keSer;
	@Autowired
	private TrService trService;
	
	
	/* crud tr_kelompok_po*/
	@GetMapping("/kelompokpo")
	public String tableKelPo(Model model) {
		List<KelompokPo> kelompokPo = trService.join();
		model.addAttribute("post", kelompokPo);
		Logger logger = LoggerFactory.getLogger(TrController.class);
		logger.info("ini"+kelompokPo);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "tr_kelompok_po");
		return "kelompok_po";
	} 
	@PostMapping(value = "savekelpo")
	public String saveKelPo(@ModelAttribute KelompokPo kelompokPo, RedirectAttributes redirectAttributes, Model model) {
		
		KelompokPo dbPo = trService.save(kelompokPo);
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
		KelompokPo kelompokPo = trService.findById(idKelompok);
		List<Kelompok> kelompok = keSer.getAllKel();
		List<Po> po = poService.getAllPo();
		model.addAttribute("po", po);
		model.addAttribute("kelompok1", kelompok);
		model.addAttribute("kelompokpo", kelompokPo);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "tr_kelompok_po");
		model.addAttribute("isAdd", false);
		return "form/formKelPo";
	}
	@PostMapping(value = "updatekelpo")
	public String update(@ModelAttribute KelompokPo kelompokPo,	RedirectAttributes redirectAttributes, Model model) {
		KelompokPo dbPo = trService.save(kelompokPo);
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
		List<Orientasi> orientasi = trService.joinOrientasiKelompok();
		model.addAttribute("orientasi", orientasi);
		Logger logger = LoggerFactory.getLogger(TrController.class);
		logger.info("data"+orientasi);
		model.addAttribute("title", "Orientasi");
		model.addAttribute("h2", "Data Orientasi");
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
		Orientasi dbPo = trService.saveOrientasi(orientasi);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/orientasi";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", orientasi);
			return "orientasi";
		}
	}
	@GetMapping(value = "getOrientasi/{idOrientasi}")
	public String getOrientasi(@PathVariable Long idOrientasi, Model model) {
		Orientasi orientasi = trService.findByIdOrientasi(idOrientasi);
		List<Kelompok> kelompok = keSer.getAllKel();
		model.addAttribute("kelompok", kelompok);
		model.addAttribute("orientasi", orientasi);
		model.addAttribute("title", "Kelompok");
		model.addAttribute("h2", "Orientasi");
		model.addAttribute("isAdd", false);
		return "form/formOrientasi";
	}
	
	@PostMapping(value = "updateorientasi")
	public String updateorientasi(@ModelAttribute Orientasi orientasi,	RedirectAttributes redirectAttributes, Model model) {
		Orientasi dbPo = trService.saveOrientasi(orientasi);
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
	/*Evaluasi*/
	@GetMapping("/evaluasi")
	public String tableevaluasi(Model model) {
		List<Evaluasi> evaluasi = trService.joinEvaluasiKelompok();
		model.addAttribute("evaluasi", evaluasi);
		model.addAttribute("title", "Orientasi");
		model.addAttribute("h2", "Data Evaluasi");
		return "evaluasi";
	} 
	@RequestMapping(value = "/eva/create", method = RequestMethod.GET)
	public String formEvaluasi(Model model) {
		List<Kelompok> kelompok = keSer.getAllKel();
		model.addAttribute("kelompok", kelompok);
		model.addAttribute("evaluasi", new Evaluasi());
		model.addAttribute("h2", "Evaluasi");
		model.addAttribute("isAdd", true);
		return "form/formEvaluasi";
	}
	@PostMapping(value = "saveevaluasi")
	public String saveEvaluasi(@ModelAttribute Evaluasi evaluasi, RedirectAttributes redirectAttributes, Model model) {
		Evaluasi dbPo = trService.saveEvaluasi(evaluasi);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/evaluasi";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", evaluasi);
			return "evaluasi";
		}
	}
	/*Realisasi*/
	@GetMapping("/realisasi")
	public String tablerealisasi(Model model) {
		List<Realisasi> realisasi = trService.joinRealisasi();
		model.addAttribute("realisasi", realisasi);
		model.addAttribute("title", "Realisasi");
		model.addAttribute("h2", "Realisasi");
		return "realisasi";
	} 
	@RequestMapping(value = "/realisasi/create", method = RequestMethod.GET)
	public String formRealisasi(Model model) {
		List<Kelompok> kelompok = keSer.getAllKel();
		model.addAttribute("kelompok", kelompok);
		model.addAttribute("realisasi", new Realisasi());
		model.addAttribute("h2", "Realisasi");
		model.addAttribute("isAdd", true);
		return "form/formRealisasi";
	}
	/*Kewajiban*/
	@GetMapping("/kewajiban")
	public String tablekewajiban(Model model) {
		model.addAttribute("h2", "Kewajiban");
		return "kewajiban";
	} 
}
