package com.helenarose.webServices.service;

import com.helenarose.webServices.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.helenarose.webServices.model.Users;

@Service
public class UserServiceImpl implements UserService {



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


}
