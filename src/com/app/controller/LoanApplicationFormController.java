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
import com.app.dao.IloanApplicationFormDao;
import com.app.pojos.LoanApplicationForm;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/loanforms")
public class LoanApplicationFormController {
	@Autowired
	private IloanApplicationFormDao service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST request handling method to get list of LoanApplicationForm
	@GetMapping
	public ResponseEntity<?> listLoanApplicationForm() {
		System.out.println("in list loanApplicationForm");
		List<LoanApplicationForm> allLoanApplicationForms = service.getAllLoanApplicationForms();
		if (allLoanApplicationForms.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<LoanApplicationForm>>(allLoanApplicationForms, HttpStatus.OK);
	}

	// REST request handling method to get loanApplicationForm by id
	@GetMapping("/{loanApplicationForm_id}")
	public ResponseEntity<?> getLoanApplicationFormDetails(@PathVariable int loanApplicationForm_id) {
		System.out.println("in loanApplicationForm dtls " + loanApplicationForm_id);
		LoanApplicationForm e = service.getLoanApplicationFormById(loanApplicationForm_id);
		if (e == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<LoanApplicationForm>(e, HttpStatus.OK);
	}

	// REST request handling method to create new resource : LoanApplicationForm
	@PostMapping
	public ResponseEntity<?> addLoanApplicationFormDetails(@RequestBody LoanApplicationForm e) {
		System.out.println("in add LoanApplicationForm dtls " + e);
		try {
			return new ResponseEntity<LoanApplicationForm>(service.addLoanApplicationFormDetails(e), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	// REST request handling method to delete existing resource : Student
	@DeleteMapping("/{loanApplicationFormId}")
	public void deleteLoanApplicationFormDetails(@PathVariable LoanApplicationForm loanApplicationFormId)
	{
		System.out.println("in delete LoanApplicationForm "+loanApplicationFormId);
		service.deleteLoanApplicationForm(loanApplicationFormId);
	}
	
	
}
