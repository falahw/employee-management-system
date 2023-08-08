package com.kastamer.sbtl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kastamer.sbtl.model.Employee;
import com.kastamer.sbtl.service.EmpService;
import com.kastamer.sbtl.web.dto.EmpRegistrationDTO;

@Controller
public class EmpMainController {
	
	@Autowired
	private EmpService empServ;

	@GetMapping("/login")
	private String login() {
		// TODO Auto-generated method stub
		return "emp-login";
	}
	
	@GetMapping("/")
	private String halKaryawan(Model model) {
		// TODO Auto-generated method stub
//		model.addAttribute("daftarKaryawan", empServ.getAllEmployees());
		
		return findPaginatedPage(1, "fullName", "asc", model); //return "pojok-karyawan";
	}
	
	@PostMapping("/simpanDataKaryawan")
	private String simpanDataKaryawan(@ModelAttribute("pekerja") Employee empl) { //EmpRegistrationDTO empl) {
		// TODO Auto-generated method stub
		empServ.simpanPembaruanData(empl); //empServ.save(empl);
		
		return "redirect:/";
	}
	
	@GetMapping("/pembaruanDataKaryawan/{empId}")
	private String pembaruanDataKaryawan(@PathVariable(value = "empId") long idKaryawan, Model model) {
		// TODO Auto-generated method stub
		Employee karyawan = empServ.getEmployeeById(idKaryawan);
		model.addAttribute("pekerja", karyawan);
		
		return "pembaruan-data-karyawan";
	}
	
	@GetMapping("/hapusKaryawan/{unik}")
	private String hapusKaryawan(@PathVariable(value = "unik") long idKaryawan) {
		// TODO Auto-generated method stub
		this.empServ.deleteEmployeeById(idKaryawan);
		
		return "redirect:/";
	}
	
	@GetMapping("/page/{pageNo}")
	private String findPaginatedPage(@PathVariable(value = "pageNo") int pageNum,
			@RequestParam("colToBeSorted") String sortField,
			@RequestParam("sortAscOrDesc") String sortDirection,
			Model model) {
		// TODO Auto-generated method stub
		int pageSize = 5;
		
		Page<Employee> page = empServ.findPaginated(pageNum, pageSize, sortField, sortDirection);
		List<Employee> empList = page.getContent();
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortCol", sortField);
		model.addAttribute("sortDir", sortDirection);
		model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("daftarKaryawan", empList);
		
		String checkVar = "variable";
		model.addAttribute("var", checkVar);
		
		return "pojok-karyawan";
	}
	/*
	@GetMapping("/halWeb/{noHalWeb}")
	private String pengurutanDanPaginasi(@PathVariable(value = "noHalWeb") int noHal, Model model) {
		// TODO Auto-generated method stub
		int ukuranHalWeb = 5;
		
		Page<Employee> halamanWeb = empServ.findPaginated(noHal, ukuranHalWeb);
		List<Employee> daftarKaryawan = halamanWeb.getContent();
		
		model.addAttribute("halWebSekarang", noHal);
		model.addAttribute("totalHalamanWeb", halamanWeb.getTotalPages());
		model.addAttribute("totalElemen", halamanWeb.getTotalElements());
		model.addAttribute("daftarPekerja", daftarKaryawan);
		
		return "pojok-karyawan";
	}
	*/
}
