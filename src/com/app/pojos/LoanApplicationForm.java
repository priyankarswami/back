package com.app.pojos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "loanapplicationform")
public class LoanApplicationForm
{
	private Integer aId;
	private int panNo;
	private Timestamp dob;
	private String name,occupation,maritalStatus,address,financeDetails;
	private double income;
	private Gender gender;
	
	private Student student;
	private AdmittedCourse course;
	private List<Bank> bank = new ArrayList<>();
	private Status status;
	
	public LoanApplicationForm() 
	{
		System.out.println("in ctor of Loanapplicationform");
	}

	public LoanApplicationForm(Integer aId, int panNo, Timestamp dob, String name, String occupation,
			String maritalStatus, String address, String financeDetails, double income, Gender gender) {
		super();
		this.aId = aId;
		this.panNo = panNo;
		this.dob = dob;
		this.name = name;
		this.occupation = occupation;
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.financeDetails = financeDetails;
		this.income = income;
		this.gender = gender;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="aid")
	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public int getPanNo() {
		return panNo;
	}

	public void setPanNo(int panNo) {
		this.panNo = panNo;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFinanceDetails() {
		return financeDetails;
	}

	public void setFinanceDetails(String financeDetails) {
		this.financeDetails = financeDetails;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@OneToOne
	@JoinColumn(name = "s_id")
	public Student getStudent() {
		return student;
	}
	
	@OneToOne	
	@JoinColumn(name = "course_id")
	public AdmittedCourse getCourse() {
		return course;
	}

	public void setCourse(AdmittedCourse course) {
		this.course = course;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@OneToMany(mappedBy ="loandtl", cascade = CascadeType.ALL, orphanRemoval = true,fetch=FetchType.EAGER)
	@JsonIgnore
	public List<Bank> getBank() {
		return bank;
	}

	public void setBank(List<Bank> bank) {
		this.bank = bank;
	}

	@OneToOne	
	@JoinColumn(name = "statusId")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
