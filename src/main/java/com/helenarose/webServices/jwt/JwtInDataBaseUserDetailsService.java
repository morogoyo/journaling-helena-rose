package com.helenarose.webServices.jwt;

import com.helenarose.webServices.model.UserDTO;
import com.helenarose.webServices.repository.UserDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtInDataBaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAORepository userDaoRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO user = userDaoRepo.findByUserName(username);

        if (user == null){
            throw new UsernameNotFoundException("User not found for username "+ username);
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());

    }


}


