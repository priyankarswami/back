package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BankDaoImpl;
import com.app.dao.IBankDao;
import com.app.pojos.Bank;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/banks")
public class BankController {
	@Autowired
	private IBankDao service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST request handling method to get list of student
	@GetMapping
	public ResponseEntity<?> listBank() {
		System.out.println("in list bank");
		List<Bank> allBanks = service.getAllBanks();
		if (allBanks.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Bank>>(allBanks, HttpStatus.OK);
	}

	// REST request handling method to get loanApplicationForm by id
	@GetMapping("/{bank_id}")
	public ResponseEntity<?> getBankDetails(@PathVariable int bank_id) {
		System.out.println("in bank dtls " + bank_id);
		Bank e = service.getBankById(bank_id);
		if (e == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Bank>(e, HttpStatus.OK);
	}

	// REST request handling method to create new resource : LoanApplicationForm
	@PostMapping
	public ResponseEntity<?> addBankDetails(@RequestBody Bank b) {
		System.out.println("in add Bank dtls " + b);
		try {
			return new ResponseEntity<Bank>(service.addBankDetails(b), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	// REST request handling method to delete existing resource : Student
	@DeleteMapping("/{bankId}")
	public void deleteBankbyId(@PathVariable int bankId)
	{
		System.out.println("in delete emp "+bankId);
		Bank b = service.getBankById(bankId);
		service.deleteBankbyId(b);
	}	
	
}
