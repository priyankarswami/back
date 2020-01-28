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

import com.app.dao.ILoanSchemeDao;
import com.app.pojos.LoanScheme;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/loanschemes")
public class LoanSchemeController {
	@Autowired
	private ILoanSchemeDao service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST request handling method to get list of student
	@GetMapping
	public ResponseEntity<?> listLoanScheme() {
		System.out.println("in list loanScheme");
		List<LoanScheme> allLoanSchemes = service.getAllLoanSchemes();
		if (allLoanSchemes.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<LoanScheme>>(allLoanSchemes, HttpStatus.OK);
	}

	// REST request handling method to get student by id
	@GetMapping("/{loanScheme_id}")
	public ResponseEntity<?> getLoanSchemeDetails(@PathVariable int loanScheme_id) {
		System.out.println("in loanScheme dtls " + loanScheme_id);
		LoanScheme e = service.getLoanSchemeById(loanScheme_id);
		if (e == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<LoanScheme>(e, HttpStatus.OK);
	}

	// REST request handling method to create new resource : Student
	@PostMapping
	public ResponseEntity<?> addLoanSchemeDetails(@RequestBody LoanScheme e) {
		System.out.println("in add LoanScheme dtls " + e);
		try {
			return new ResponseEntity<LoanScheme>(service.addLoanSchemeDetails(e), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// REST request handling method to delete existing resource : Student
	@DeleteMapping("/{loanSchemeId}")
	public void deleteLoanSchemeDetails(@PathVariable LoanScheme loanSchemeId)
	{
		System.out.println("in delete emp "+loanSchemeId);
		service.deleteLoanScheme(loanSchemeId);
	}

}
