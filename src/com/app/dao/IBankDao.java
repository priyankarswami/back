package com.app.dao;

import java.util.List;

import com.app.pojos.Bank;

public interface IBankDao 
{
	//void getBankById(int bankId);
	Bank validateBank(String email, String pass);
	List<Bank> getAllBanks();
	Bank getBankById(int bankId);
	Bank addBankDetails(Bank b);//e --transient 
	void deleteBankbyId(Bank b);
	//void getBankById(Bank bankId);
}
