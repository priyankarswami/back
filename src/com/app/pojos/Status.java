package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "status")
public class Status 
{
	private Integer statusId;
	private String status;
	private Bank bank;
	private LoanApplicationForm form;
	
	public Status() {
		System.out.println("in ctor of Status");
	}
	
	public Status(String status) {
		super();
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="status_id")
	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToOne(mappedBy = "stat", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnore
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@OneToOne(mappedBy = "status" , cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnore
	public LoanApplicationForm getForm() {
		return form;
	}

	public void setForm(LoanApplicationForm form) {
		this.form = form;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", status=" + status + ", bank=" + bank + ", form=" + form + "]";
	}
	
}
