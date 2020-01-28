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

import com.app.dao.IStudentDao;
import com.app.dao.IloanApplicationFormDao;
import com.app.pojos.LoanApplicationForm;
import com.app.pojos.Student;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private IStudentDao service;
	private IloanApplicationFormDao form;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST request handling method to get list of student
	@GetMapping
	public ResponseEntity<?> listStudent() {
		System.out.println("in list student");
		List<Student> allStudents = service.getAllStudents();
		if (allStudents.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}

	// REST request handling method to get student by id
	@GetMapping("/{student_id}")
	public ResponseEntity<?> getStudentDetails(@PathVariable int student_id) {
		System.out.println("in student dtls " + student_id);
		Student e = service.getStudentById(student_id);
		if (e == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Student>(e, HttpStatus.OK);
	}

	// REST request handling method to create new resource : Student
	@PostMapping
	public ResponseEntity<?> addStudentDetails(@RequestBody Student e) {
		System.out.println("in add Student dtls " + e);
		try {
			return new ResponseEntity<Student>(service.addStudentDetails(e), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/login",consumes = "application/json")
	public ResponseEntity<?> Login(@RequestBody Student e) {
		System.out.println("in add Student dtls " + e);
		try {
			return new ResponseEntity<Student>(service.validateStudent(e.getEmail(), e.getPassword()), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// REST request handling method to delete existing resource : Student
	@DeleteMapping("/{studentId}")
	public void deleteStudentDetails(@PathVariable Student studentId)
	{
		System.out.println("in delete emp "+studentId);
		service.deleteStudent(studentId);
	}

	@PostMapping(path = "/loanforms",consumes = "application/json")
	public ResponseEntity<?> addLoanApplicationForm(@RequestBody LoanApplicationForm l) {
		System.out.println("in add LoanApplicationForm dtls " + l);
		try {
			return new ResponseEntity<LoanApplicationForm>(form.addLoanApplicationFormDetails(l), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
