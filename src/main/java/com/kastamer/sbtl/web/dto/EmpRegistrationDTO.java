package com.kastamer.sbtl.web.dto;

public class EmpRegistrationDTO {

	private String fullName;
	private String email;
	private String password;
	private String empId;
	/*
	public EmpRegistrationDTO(String fullName, String email, String password, String empId) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.empId = empId;
	}
	*/
	public EmpRegistrationDTO(String fullName, String email, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}
	
	public EmpRegistrationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	*/
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
