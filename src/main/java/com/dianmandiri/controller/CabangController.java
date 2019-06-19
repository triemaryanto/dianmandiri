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
import com.dianmandiri.entity.HistoryCabang;
import com.dianmandiri.entity.HistoryMs;
import com.dianmandiri.entity.HistoryPo;
import com.dianmandiri.entity.Po;
import com.dianmandiri.service.cabang.CabangService;
import com.dianmandiri.service.cabang.HisCabService;
import com.dianmandiri.service.historyms.HistoryMsService;

@Controller
public class CabangController {
	
	@Autowired
	private CabangService cabangService;
	@Autowired 
	private HistoryMsService historyMsService;

	@GetMapping("/cabang")
	public String tableCabang(Model model) {		
		List<Cabang> cabang = cabangService.getAllCabang();
		model.addAttribute("cabang", cabang);
		model.addAttribute("title", "Cabang Dian Mandiri");
		model.addAttribute("h2", "Data Cabang");
		return "cabang";
	}

	@RequestMapping(value = "/cabang/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("cabang", new Cabang());
		model.addAttribute("title", "Form Cabang");
		model.addAttribute("h2", "Tambah Data");
		model.addAttribute("isAdd", true);
		return "form/formCab";
	}

	@GetMapping("/cabang/history")
	public String HistoryCabang(Model model) {
		List<HistoryMs> historyMs = historyMsService.getHistoryCabang();
		List<Cabang> cab = cabangService.getAllCabang();
		model.addAttribute("ms", historyMs);
		model.addAttribute("cab", cab);
		model.addAttribute("title", "Cabang Dian Mandiri");
		model.addAttribute("h2", "History Data Cabang");
		return "historyCab";
	}
	@PostMapping(value = "savecab")
	public String saveCabang(@ModelAttribute Cabang cabang, RedirectAttributes redirectAttributes, Model model) {
		
		Cabang dbPo = cabangService.save(cabang);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/cabang";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", cabang);
			return "cabang";
		}
	}
	@GetMapping(value = "getCabang/{idCabang}")
	public String getPo(@PathVariable Long idCabang, Model model) {
		Cabang cabang = cabangService.findById(idCabang);		
		model.addAttribute("cabang", cabang);
		model.addAttribute("title", "Cabang Dian Mandiri");
		model.addAttribute("h2", "Edit Data Cabang");
		model.addAttribute("isAdd", false);
		return "form/formCab";
	}
	@PostMapping(value = "updatecab")
	public String update(@ModelAttribute Cabang cabang, HistoryCabang hiscab, HistoryMs historyMs, RedirectAttributes redirectAttributes, Model model) {	
		Cabang datasebelum = cabangService.findById(cabang.getIdCabang());			
		Cabang OldPo = cabangService.findidCabang().get(0);
		Long idPo = OldPo.getIdCabang();
		historyMs.setIdCabang(null);
		historyMs.setPage("cabang");
		historyMs.setIdRelasi(cabang.getIdCabang());
		historyMs.setNama(datasebelum.getNamaCabang());
		historyMs.setTelepon(datasebelum.getTelepon());
		historyMs.setIsactive(0);
		historyMs.setStartdt(datasebelum.getStartdt());
		historyMs.setEnddt(new Date());
		historyMsService.save(historyMs);
		Cabang dbPo = cabangService.save(cabang);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil di update Disimpan");
			return "redirect:/cabang";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", cabang);
			return "cabang";
		}
	}
}
