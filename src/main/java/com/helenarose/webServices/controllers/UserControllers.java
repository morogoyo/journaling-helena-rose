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

import java.util.List;
import java.util.Optional;


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
        List<Users> users = userRepo.findAll();
        return new ResponseEntity<List<Users>>(users, HttpStatus.OK) {
        };
    }

    @PutMapping(value = "/refactor")
//	TODO need to see how this will work and from what screen it will becoming in posibly will need a jwt token search
    public ResponseEntity<?> refactorUser(@RequestBody Users user) {
        LOG.info(user.toString());
        Users userToBeUpdated = userRepo.findByFnameAndLname(user.getFname(), user.getFname());
        LOG.info(userToBeUpdated.toString());
//		userRepo.save(userToBeUpdated);
        return new ResponseEntity<Users>(HttpStatus.OK) {
        };
    }


    @PostMapping(value = "/insert", consumes = "application/json")
    public ResponseEntity<?> insertUser(@RequestBody Users user) {
        Optional<Users> updatedUser = Optional.empty();
        LOG.info(user.toString());
        boolean foundUser = userService.findByEmail(user.getEmail());
        if (!foundUser) {
            updatedUser = Optional.ofNullable(userService.passIdToCascadingEntity(user));
            LOG.info("this is the user email and password being passed to be saved {},{}", user.getUserDTO().getEmail(), user.getUserDTO().getId());
            LOG.info("/////////////////////{}////////////////////////////", updatedUser.get().toString());
            userRepo.save(updatedUser.get());
            return new ResponseEntity<Users>(HttpStatus.OK);
        } else {
            LOG.info("Email is not Unique");
            return new ResponseEntity<>("Email is not Unique", HttpStatus.NOT_ACCEPTABLE);
        }


    }

}
