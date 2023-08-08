package com.kastamer.sbtl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.kastamer.sbtl.model.Employee;
import com.kastamer.sbtl.web.dto.EmpRegistrationDTO;

public interface EmpService extends UserDetailsService {

	Employee save(EmpRegistrationDTO empRegistrationDTO);
	
	//PART POJOK KLIEN
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	
	Page<Employee> findPaginated(int pageNo, int PageSize, String sortField, String sortAscOrDesc);
//	Page<Employee> findPaginated(int nomorHalaman, int ukuranHalanman);
	
	void simpanPembaruanData(Employee employee);
}
