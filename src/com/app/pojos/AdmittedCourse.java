package com.app.pojos;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "admittedcourse")
public class AdmittedCourse 
{
	private Integer cId;
	private String instituteName,city,country;
	private Date startDate,endDate;
	private double totalExpenses;
	
	private LoanApplicationForm form;
	
	public AdmittedCourse() {
		System.out.println("in ctor of AdmittedCourse");
	}

	public AdmittedCourse(Integer cId, String instituteName, String city, String country, Date startDate, Date endDate,
			double totalExpenses, LoanApplicationForm form) {
		super();
		this.instituteName = instituteName;
		this.city = city;
		this.country = country;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalExpenses = totalExpenses;
		this.form = form;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getInstituteName() {
		return instituteName;
	}
	
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	@OneToOne(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true,fetch=FetchType.EAGER)
	@JsonIgnore
	public LoanApplicationForm getForm() {
		return form;
	}

	public void setForm(LoanApplicationForm form) {
		this.form = form;
	}


//	@Override
//	public String toString() {
//		return "AdmittedCourse [cId=" + cId + ", instituteName=" + instituteName + ", city=" + city + ", country="
//				+ country + ", startDate=" + startDate + ", endDate=" + endDate + ", totalExpenses=" + totalExpenses
//				+ "]";
//	}

}
