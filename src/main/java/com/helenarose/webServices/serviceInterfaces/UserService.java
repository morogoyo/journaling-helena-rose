package com.helenarose.webServices.serviceInterfaces;

import com.helenarose.webServices.model.Users;

import java.util.Optional;

public interface UserService {
	
	public Users userUpdate(Users user);

	public String encryptPassword(String password);

	public Users passIdToCascadingEntity(Users user);

	public boolean findByEmail(String email);
}
