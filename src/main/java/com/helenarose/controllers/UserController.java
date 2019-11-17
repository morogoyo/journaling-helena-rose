package com.helenarose.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.helenarose.model.Users;
import com.helenarose.repository.UserRepository;



@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	@PostMapping(value = "/insert")
	public ResponseEntity<?> insertUser(@RequestBody Users user) {
		LOG.info(user.toString());
		userRepo.save(user);
		return new ResponseEntity<Users>(HttpStatus.OK) {
		};
	}

}
