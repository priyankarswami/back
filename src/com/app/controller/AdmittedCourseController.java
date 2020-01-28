package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAdmittedCourseDao;
import com.app.pojos.AdmittedCourse;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/course")
public class AdmittedCourseController {
	@Autowired
	private IAdmittedCourseDao service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST request handling method to get list of student
	@GetMapping
	public ResponseEntity<?> listAdmittedCourse() {
		System.out.println("in list admittedCourse");
		List<AdmittedCourse> allAdmittedCourses = service.getAllAdmittedCourses();
		if (allAdmittedCourses.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<AdmittedCourse>>(allAdmittedCourses, HttpStatus.OK);
	}

	// REST request handling method to get student by id
	@GetMapping("/{admittedCourse_id}")
	public ResponseEntity<?> getAdmittedCourseDetails(@PathVariable int admittedCourse_id) {
		System.out.println("in admittedCourse dtls " + admittedCourse_id);
		AdmittedCourse e = service.getAdmittedCourseById(admittedCourse_id);
		if (e == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<AdmittedCourse>(e, HttpStatus.OK);
	}

	// REST request handling method to create new resource : Student
	@PostMapping
	public ResponseEntity<?> addAdmittedCourseDetails(@RequestBody AdmittedCourse e) {
		System.out.println("in add admittedCourse dtls " + e);
		try {
			return new ResponseEntity<AdmittedCourse>(service.addAdmittedCourseDetails(e), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
