package com.helenarose.webServices.service;

import com.helenarose.webServices.repository.UserRepository;
import com.helenarose.webServices.serviceInterfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.helenarose.webServices.model.Users;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Users userUpdate(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encryptPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encrypted = encoder.encode(password);
		return encrypted;
	}

	@Override
	public Users passIdToCascadingEntity(Users user) {
		user.getUserDTO().setPassword(userService.encryptPassword(user.getUserDTO().getPassword()));
		user.getUserDTO().setEmail(user.getEmail());
		user.getUserDTO().setId(user.getId());

		return user;
	}

	@Override
	public boolean findByEmail(String email) {
		Optional byEmail = Optional.ofNullable(userRepository.findByEmail(email));
		LOG.info(byEmail.toString());
		LOG.info("////////////////////////////////{}///////////////////////////////////////",byEmail.isPresent());
		if(!byEmail.isPresent()){
			return false;
		}else{
			return true;
		}

	}


}
