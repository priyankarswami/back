package com.app.dao;

import java.util.List;

import com.app.pojos.LoanScheme;

public interface ILoanSchemeDao {
	LoanScheme getLoanSchemeById(int loanSchemeId);
	LoanScheme addLoanSchemeDetails(LoanScheme l);//e --transient 
	void deleteLoanScheme(LoanScheme l);
	List<LoanScheme> getAllLoanSchemes();
}
