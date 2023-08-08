package com.kastamer.sbtl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kastamer.sbtl.service.EmpService;
import com.kastamer.sbtl.web.dto.EmpRegistrationDTO;

@Controller
@RequestMapping("/registrasi")
public class EmpRegistrationController {

	private EmpService empService;

	public EmpRegistrationController(EmpService empService) {
		super();
		this.empService = empService;
	}
	
	@PostMapping
	private String daftarKaryawanBaru(@ModelAttribute("karyawan") EmpRegistrationDTO empRegDTO) {
		// TODO Auto-generated method stub
		empService.save(empRegDTO);
		
		return "redirect:/registrasi?berhasil";
	}
	
	@GetMapping
	private String tampilFormRegistrasi(Model model) {
		// TODO Auto-generated method stub
		return "registrasi";
	}
	
	@ModelAttribute("karyawan")
	private EmpRegistrationDTO empRegDTO() {
		// TODO Auto-generated method stub
		return new EmpRegistrationDTO();
	}
}
