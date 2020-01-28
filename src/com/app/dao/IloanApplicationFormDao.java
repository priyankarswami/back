package com.app.dao;

import java.util.List;

import com.app.pojos.LoanApplicationForm;

public interface IloanApplicationFormDao {
//	LoanApplicationForm validateLoanApplicationForm(String email, String pass);
	List<LoanApplicationForm> getAllLoanApplicationForms();
	LoanApplicationForm getLoanApplicationFormById(int loanApplicationFormId);
	LoanApplicationForm addLoanApplicationFormDetails(LoanApplicationForm l);//e --transient 
	void deleteLoanApplicationForm(LoanApplicationForm l);

}
