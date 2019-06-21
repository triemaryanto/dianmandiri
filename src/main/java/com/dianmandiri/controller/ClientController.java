package com.dianmandiri.controller;

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
import com.dianmandiri.entity.Client;
import com.dianmandiri.service.client.ClientService;

@Controller
public class ClientController {
	
	
	@Autowired
	private ClientService clientService;
	

	@GetMapping("/client")
	public String Pos(Model model) {
		List<Client> client = clientService.getAllClient();
		model.addAttribute("client", client);
		model.addAttribute("title", "Cabang Dian Mandiri");
		model.addAttribute("h2", "Data Cabang");
		return "client";
	}
	
	@RequestMapping(value = "/client/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("title", "Form Client");
		model.addAttribute("h2", "Tambah Data");
		model.addAttribute("isAdd", true);
		return "form/formClient";
	}
	@PostMapping(value = "saveclient")
	public String saveCabang(@ModelAttribute Client client, RedirectAttributes redirectAttributes, Model model) {
		Client dbPo = clientService.save(client);
		if (dbPo != null) {
			redirectAttributes.addFlashAttribute("succesmessage", "Data Berhasil Disimpan");
			return "redirect:/client";
		} else {
			model.addAttribute("errormessage", "Data Progam Officer Tidak Berhasil Di Simpan, Coba Lagi!");
			model.addAttribute("po", client);
			return "client";
		}
	}
	@GetMapping(value = "getClient/{idClient}")
	public String getPo(@PathVariable Long idClient, Model model) {
		Client client = clientService.findById(idClient);		
		model.addAttribute("client", client);
		model.addAttribute("title", "Client");
		model.addAttribute("h2", "Edit Data");
		model.addAttribute("isAdd", false);
		return "/form/formClient";
	}
}
