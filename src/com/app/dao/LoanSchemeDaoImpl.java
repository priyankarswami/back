package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.LoanScheme;

@Repository
@Transactional
public class LoanSchemeDaoImpl implements ILoanSchemeDao{
	@Autowired
	private SessionFactory sf;

	@Override
	public LoanScheme getLoanSchemeById(int loanSchemeId)
	{
		
		return sf.getCurrentSession().get(LoanScheme.class, loanSchemeId);
	}

	@Override
	public LoanScheme addLoanSchemeDetails(LoanScheme l) {
		sf.getCurrentSession().persist(l);
		return l;
	}
	@Override
	public void deleteLoanScheme(LoanScheme l) {
		sf.getCurrentSession().delete(l);
		
	}

	@Override
	public List<LoanScheme> getAllLoanSchemes() {
		String jpql = "select l from LoanScheme l";
		return sf.getCurrentSession().createQuery(jpql, LoanScheme.class).getResultList();
	}	
}
