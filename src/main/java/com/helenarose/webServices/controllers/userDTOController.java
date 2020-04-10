package com.helenarose.webServices.controllers;


import com.helenarose.webServices.model.UserDTO;
import com.helenarose.webServices.model.Users;
import com.helenarose.webServices.repository.UserDAORepository;
import com.helenarose.webServices.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1/admin")
public class userDTOController {
	
	private static final Logger LOG = LoggerFactory.getLogger(userDTOController.class);
	
	
	@Autowired
	private UserDAORepository userDAORepository;

	@Autowired
	private UserRepository userRepo;


//	TODO Add some request parameter or path variables not sure what I want to do right now
	@GetMapping(value = "/account/{email}")
	public ResponseEntity<?> getAll(@PathVariable(name = "email") String email) {
		Optional<Users> users =  Optional.ofNullable(userRepo.findByEmail(email));

		if(!users.isPresent()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
//	@PutMapping(value = "/refactor")
////	TODO need to see how this will work and from what screen it will becoming in posibly will need a jwt token search
//	public ResponseEntity<?> refactorUser(@RequestBody Users users) {
//		LOG.info(users.toString());
//		Users userToBeUpdated = userRepo.findByEmail(users.getEmail());
//		LOG.info(userToBeUpdated.toString());
////		userRepo.save(userToBeUpdated);
//		return new ResponseEntity<Users>(HttpStatus.OK) {
//		};
//	}

//
	@PostMapping(value = "/insert", consumes = "application/json")
	public ResponseEntity<?> insertUser(@NotNull @RequestBody Users user) {


		return new ResponseEntity<Users>(HttpStatus.OK) {
		};
	}

}
