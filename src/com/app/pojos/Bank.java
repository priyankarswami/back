package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "banks")
public class Bank {
	private Integer bId;
	private String name, branch, email, password;
	private int ifsc;
	private Role role;
	
	@JsonIgnore
	private List<LoanScheme> loanscheme = new ArrayList<>();	
	//@JsonIgnore
	private LoanApplicationForm loandtl;
	//@JsonIgnore
	private Status stat;
	
	public Bank() {
		System.out.println("in ctor of Bank");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid")
	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getIfsc() {
		return ifsc;
	}

	public void setIfsc(int ifsc) {
		this.ifsc = ifsc;
	}

	@Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy = "bank" , cascade = CascadeType.ALL, orphanRemoval = true,fetch=FetchType.LAZY)
	//@JsonIgnore
	public List<LoanScheme> getLoanscheme() {
		return loanscheme;
	}

	public void setLoanscheme(List<LoanScheme> loanscheme) {
		this.loanscheme = loanscheme;
	}
	
	@ManyToOne
	@JoinColumn(name = "loan_id")
	public LoanApplicationForm getLoandtl() {
		return loandtl;
	}

	public void setLoandtl(LoanApplicationForm loandtl) {
		this.loandtl = loandtl;
	}

	
	@OneToOne
	@JoinColumn(name = "statusId")
	public Status getStat() {
		return stat;
	}


	public void setStat(Status stat) {
		this.stat = stat;
	}

//	@Override
//	public String toString() {
//		return "Bank [bId=" + bId + ", name=" + name + ", branch=" + branch + ", email=" + email + ", password="
//				+ password + ", ifsc=" + ifsc + ", role=" + role + "]";
//	}

}
