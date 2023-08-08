package com.kastamer.sbtl.model;

import java.util.Collection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "karyawan_ems", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee {

	@Id
	@Column(name = "emp_id")
	@SequenceGenerator(name = "IdGenerator", initialValue = 1000) //SET INITIAL VALUE for Id
	@GeneratedValue(generator = "IdGenerator", strategy = GenerationType.IDENTITY)
	private Long empId;
	
	private String fullName;
	private String email;
	private String password;
	
//	private BCryptPasswordEncoder encodeKataSandi;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	
	@JoinTable(
			name = "emp_role_ems",
			joinColumns = @JoinColumn(
					referencedColumnName = "emp_id", name = "emp_id"),
			inverseJoinColumns = @JoinColumn(
					referencedColumnName = "id_role", name = "role_id"))
	private Collection<EmpRole> roles;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String fullName, String email, String password, Collection<EmpRole> roles) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

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

	public Collection<EmpRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<EmpRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + "]";
	}
}
