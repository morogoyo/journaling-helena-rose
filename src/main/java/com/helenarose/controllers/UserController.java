package com.helenarose.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.helenarose.model.Users;
import com.helenarose.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;



@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(value = "/select-all")
	public ResponseEntity<?> getAll() {		
		List <Users> users = userRepo.findAll();
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK) {
		};
	}
	
	@PutMapping(value = "/refactor")
//	TODO need to see how this will work and from what screen it will becoming in posibly will need a jwt token search
	public ResponseEntity<?> refactorUser(@RequestBody Users user) {
		LOG.info(user.toString());
		Users userToBeUpdated = userRepo.findByFnameAndLname(user.getFname(),user.getFname());
		LOG.info(userToBeUpdated.toString());
//		userRepo.save(userToBeUpdated);
		return new ResponseEntity<Users>(HttpStatus.OK) {
		};
	}
	
	
	@PostMapping(value = "/insert", consumes = "application/json")
	public ResponseEntity<?> insertUser(@RequestBody Users user) {
		LOG.info(user.toString());
		userRepo.save(user);
		return new ResponseEntity<Users>(HttpStatus.OK) {
		};
	}

}
