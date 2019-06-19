/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianmandiri.controller;

import com.dianmandiri.entity.Po;
import com.dianmandiri.entity.HistoryMs;
import com.dianmandiri.entity.HistoryPo;
import com.dianmandiri.service.HistoryService;
import com.dianmandiri.service.PoService;
import com.dianmandiri.service.historyms.HistoryMsService;

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

@Controller
public class PoController {

	@Autowired
	private PoService poService;

	@Autowired
	private HistoryService poSer;
	@Autowired 
	private HistoryMsService historyMsService;

	@GetMapping("/po")
	public String Pos(Model model) {
		List<Po> pos = poService.getAllPo();
		model.addAttribute("pos", pos);
		model.addAttribute("po", new Po());
		model.addAttribute("title", "Program Officer");
		model.addAttribute("h2", "Data Program Officer");
		model.addAttribute("isAdd", true);
		return "po";
	}

	@GetMapping("/po/history")
	public String History(Model model) {
		List<HistoryMs> pos = historyMsService.findpo();
		List<Po> po = poService.getAllPo();
		model.addAttribute("pos", pos);
		model.addAttribute("po", po);
		model.addAttribute("title", "Program Officer");
		model.addAttribute("h2", "History Data");
		return "historyPo";
	}

	@RequestMapping(value = "/po/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		List<Po> pos = poService.findidPo();
		model.addAttribute("pos", pos);
		model.addAttribute("po", new Po());
		model.addAttribute("title", "Program Officer");
		model.addAttribute("h2", "Tambah Data");
		model.addAttribute("isAdd", true);
		return "form/formPo";
	}

	@PostMapping(value = "save")
	public String save(@ModelAttribute Po po, RedirectAttributes redirectAttributes, Model model) {
		
		Po dbPo = poService.save(po);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/po";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", po);
			return "po";
		}
	}

	@GetMapping(value = "getPo/{idPo}")
	public String getPo(@PathVariable Long idPo, Model model) {
		Po po = poService.findById(idPo);
		List<Po> pos = poService.getAllPo();
		// po.setIsactive(0);
		// po.setEnddt(new Date());
		Po dbPo = poService.save(po);
		model.addAttribute("pos", pos);
		model.addAttribute("po", po);
		model.addAttribute("title", "Program Officer");
		model.addAttribute("h2", "Edit Data");
		model.addAttribute("isAdd", false);
		return "form/formPo";
	}

	@PostMapping(value = "update")
	public String update(@ModelAttribute Po po, HistoryMs historyMs,
			RedirectAttributes redirectAttributes, Model model) {
		Po j = poService.findById(po.getIdPo());		
		// a
		historyMs.setIdCabang(null);
		historyMs.setPage("po");
		historyMs.setIdRelasi(j.getIdPo());
		historyMs.setNama(j.getNamaPo());
		historyMs.setTelepon(j.getAlamatPo());
		historyMs.setIsactive(0);
		historyMs.setStartdt(j.getStartdt());
		historyMs.setEnddt(new Date());
		historyMsService.save(historyMs);
		
		Po dbPo = poService.save(po);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil di update Disimpan");
			return "redirect:/po";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", po);
			return "po";
		}
	}
}
