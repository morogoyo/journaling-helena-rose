package com.helenarose.webServices.jwt;

import com.helenarose.webServices.model.UserDTO;
import com.helenarose.webServices.repository.UserDAORepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Qualifier("inDatabase")
public class JwtInDataBaseUserDetailsService implements UserDetailsService {

    private final Logger LOG = LoggerFactory.getLogger(JwtInDataBaseUserDetailsService.class);

    @Autowired
    private UserDAORepository userDaoRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO user = userDaoRepo.findByUserName(username);
        LOG.info("user Credentials username:{}" , user.getUserName() == null ? null : user.getUserName());
        LOG.info("user Credentials password:{}" , user.getPassword() == null ? null : user.getPassword());


        if (user == null){
            throw new UsernameNotFoundException("User not found for username "+ username);
        }

        JwtUserDetails jwtUser = new JwtUserDetails(user.getId(),user.getUserName(),user.getPassword(),user.getRole());

        


        return jwtUser;

    }


}


