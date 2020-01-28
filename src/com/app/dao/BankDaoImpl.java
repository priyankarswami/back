package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojos.Bank;

@Repository
@Transactional
public class BankDaoImpl implements IBankDao {
	@Autowired
	private SessionFactory sf;

	public List<Bank> getAllBanks() {
		String jpql = "select b from Bank b";
		return sf.getCurrentSession().createQuery(jpql, Bank.class).getResultList();
	}

	
//	
	@Override
	public Bank getBankById(int bankId) {
		return sf.getCurrentSession().get(Bank.class, bankId);
}

	@Override
	public Bank addBankDetails(Bank b) {
		sf.getCurrentSession().persist(b);
		return b;
	}

	@Override
	public void deleteBankbyId(Bank b) {
		sf.getCurrentSession().delete(b);
		
	}
	
	@Override
	public Bank validateBank(String email1, String pass1) {
		String jpql = "select b from Bank b where b.email=:em and b.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Bank.class).setParameter("em", email1)
				.setParameter("pass", pass1).getSingleResult();
	}
	
	/*@Override
	public Role validateBank(String email1, String pass1) {
		String jpql = "select b from Bank b where b.email=:em and b.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Role.BANK).setParameter("em", email1)
				.setParameter("pass", pass1).getSingleResult();
	}*/
}
