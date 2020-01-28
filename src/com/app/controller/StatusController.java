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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IStatusDao;
import com.app.pojos.Status;


@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/status")
public class StatusController 
{
	@Autowired
	private IStatusDao service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	
	@PostMapping
	public ResponseEntity<?> addStatusDetails(@RequestBody Status e) {
		System.out.println("in add Status dtls " + e);
		try {
			return new ResponseEntity<Status>(service.addStatusDetails(e), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> listStatus() {
		System.out.println("in list status");
		List<Status> allStatus = service.getAllStatus();
		if (allStatus.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Status>>(allStatus, HttpStatus.OK);
	}

	// REST request handling method to get student by id
	@GetMapping("/{status_id}")
	public ResponseEntity<?> getStatusDetails(@PathVariable int status_id) {
		System.out.println("in status dtls " + status_id);
		Status e = service.getStatusById(status_id);
		if (e == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Status>(e, HttpStatus.OK);
	}
	
	//Edit status by Id
		@PutMapping("/{status_id}")
		public ResponseEntity<?> update(@PathVariable( "status_id" )int status_id,@RequestBody Status status){
			service.updateStatus(status_id, status);
			return ResponseEntity.ok().body("Status has Edited");
		}



}
