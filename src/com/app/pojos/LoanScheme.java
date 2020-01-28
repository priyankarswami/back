package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "loanscheme")
public class LoanScheme 
{
	private Integer lId;
	private String schemeName, description;
	private double amount;
	
	
	
	private Bank bank;
	
	public LoanScheme() {
		System.out.println("in ctor of LoanScheme");
	}

	public LoanScheme(Integer lId, String schemeName, String description, double amount) {
		super();
		this.schemeName = schemeName;
		this.description = description;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loan_id")
	public Integer getlId() {
		return lId;
	}

	public void setlId(Integer lId) {
		this.lId = lId;
	}

	public String getSchemename() {
		return schemeName;
	}

	public void setSchemename(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@ManyToOne	
	@JoinColumn(name = "bank_id")
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "LoanScheme [lId=" + lId + ", schemeName=" + schemeName + ", description=" + description + ", amount="
				+ amount + ", bank_id=" + bank + "]";
	}
	
}
