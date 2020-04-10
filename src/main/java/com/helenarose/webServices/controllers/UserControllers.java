package com.helenarose.webServices.controllers;


import com.helenarose.webServices.model.Users;
import com.helenarose.webServices.repository.UserRepository;
import com.helenarose.webServices.serviceInterfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/user")
public class UserControllers {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserControllers.class);
	
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;
	
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
	public ResponseEntity<?> insertUser(@NotNull @RequestBody Users user) {
		LOG.info(user.toString());
		user.getUserDTO().setPassword(userService.encryptPassword(user.getUserDTO().getPassword()));
		user.getUserDTO().setEmail(user.getEmail());
		LOG.info(user.getUserDTO().getEmail());
		userRepo.save(user);

		return new ResponseEntity<Users>(HttpStatus.OK) {
		};
	}

}
