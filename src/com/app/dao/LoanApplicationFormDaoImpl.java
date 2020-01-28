package com.app.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.LoanApplicationForm;

@Repository
@Transactional
public class LoanApplicationFormDaoImpl implements IloanApplicationFormDao{
	@Autowired
	private SessionFactory sf;

	public List<LoanApplicationForm> getAllLoanApplicationForms() {
		String jpql = "select l from LoanApplicationForm l";
		List<LoanApplicationForm> l=sf.getCurrentSession().createQuery(jpql, LoanApplicationForm.class).getResultList();
		for (LoanApplicationForm loanApplicationForm : l) {
			System.out.println("list of application forms..="+loanApplicationForm.getName());
			
			System.out.println("list of application forms courses:"+loanApplicationForm.getCourse().getInstituteName());
		}
		
		return l;
	}

	@Override
	public LoanApplicationForm getLoanApplicationFormById(int loanApplicationFormId)
	{
		
		return sf.getCurrentSession().get(LoanApplicationForm.class, loanApplicationFormId);
	}

	@Override
	public LoanApplicationForm addLoanApplicationFormDetails(LoanApplicationForm l) {
		sf.getCurrentSession().persist(l);
		return l;
	}
	
	@Override
	public void deleteLoanApplicationForm(LoanApplicationForm l) {
		sf.getCurrentSession().delete(l);
		
	}

}
