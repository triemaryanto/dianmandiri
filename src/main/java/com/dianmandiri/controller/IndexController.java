package com.dianmandiri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dianmandiri.entity.Cabang;
import com.dianmandiri.entity.Client;
import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.entity.Po;
import com.dianmandiri.service.PoService;
import com.dianmandiri.service.cabang.CabangService;
import com.dianmandiri.service.client.ClientService;
import com.dianmandiri.service.kelompok.KelompokService;

@Controller
public class IndexController {

	
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("title", "Dashboard");
		model.addAttribute("h2", "Welcome To Sistem");
		return "index5";
	}
	
}
