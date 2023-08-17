package com.kastamer.sbtl.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kastamer.sbtl.model.EmpRole;
import com.kastamer.sbtl.model.Employee;
import com.kastamer.sbtl.repository.EmployeeRepository;
import com.kastamer.sbtl.web.dto.EmpRegistrationDTO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmployeeRepository empRepDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	//@Autowired //THIS is ADDITION to AVOID CIRCULAR REFERENCE --> ANNOTATION NOT WORKING
	//public EmpServiceImpl(@Lazy EmployeeRepository empRepDAO) { //ANNOTATION '@Lazy' is ADDITION to AVOID CIRCULAR REFERENCE --> ANNOTATION NOT WORKING
	public EmpServiceImpl(EmployeeRepository empRepDAO) {
		super();
		this.empRepDAO = empRepDAO;
	}
	/*
	@Autowired
	public EmpServiceImpl(EmployeeRepository empRepDAO, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.empRepDAO = empRepDAO;
		this.passwordEncoder = passwordEncoder;
	}	
	*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Employee pegawai = empRepDAO.findByEmail(username);
		
		if (pegawai == null) {
			throw new UsernameNotFoundException("Email atau kata sandi tidak cocok!");
		}
		
		return new org.springframework.security.core.userdetails.User(pegawai.getEmail(), pegawai.getPassword(), mapRolesToAuthority(pegawai.getRoles())); //return null;
	}

	@Override
	public Employee save(EmpRegistrationDTO empRegistrationDTO) {
		// TODO Auto-generated method stub
		Employee karyawan = new Employee(
				empRegistrationDTO.getFullName(),
				empRegistrationDTO.getEmail(),
				passwordEncoder.encode(empRegistrationDTO.getPassword()),
				Arrays.asList(new EmpRole("ROLE_USER")));
		
		return empRepDAO.save(karyawan); //return null;
	}

	@Override
	public void simpanPembaruanData(Employee employee) {
		// TODO Auto-generated method stub
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		
		this.empRepDAO.save(employee);
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthority(Collection<EmpRole> roles) {
		// TODO Auto-generated method stub
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNamaRole())).collect(Collectors.toList());
	}

	//PART POJOK KARYAWAN
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepDAO.findAll(); //return null;
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optEmp = empRepDAO.findById(id);
		Employee empl = null;
		
		if (optEmp.isPresent()) {
			empl = optEmp.get();
		} else {
			throw new RuntimeException("Karyawan dengan emp_id '" + id + "' tidak bisa ditemukan");
		}
		
		return empl; //return null;
	}

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.empRepDAO.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortAscOrDesc) {
		// TODO Auto-generated method stub
		Sort runut = sortAscOrDesc.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, runut);
		
		return this.empRepDAO.findAll(pageable); //return null;
	}
}
