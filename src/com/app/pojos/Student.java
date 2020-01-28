package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class Student 
{
	private Integer sId;
	private String name;
	private String mobile;
	private String email,password,confirmPassword;
	
	
	private LoanApplicationForm form;
	
	public Student() {
		System.out.println("in ctor of Student");
	}

	public Student(Integer sId, String name, String mobile, String email, String password, String confirmPassword,
			LoanApplicationForm form) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.form = form;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}
	

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Column(length = 20, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 20, nullable = false)
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	@OneToOne(mappedBy = "student" , cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnore
	public LoanApplicationForm getForm() {
		return form;
	}

	public void setForm(LoanApplicationForm form) {
		this.form = form;
	}


	
	
}
