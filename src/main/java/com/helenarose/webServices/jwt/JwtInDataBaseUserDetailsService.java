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
import java.util.Optional;

@Service
@Qualifier("inDatabase")
public class JwtInDataBaseUserDetailsService implements UserDetailsService {

    private final Logger LOG = LoggerFactory.getLogger(JwtInDataBaseUserDetailsService.class);

    @Autowired
    private UserDAORepository userDaoRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDTO> user = Optional.of(userDaoRepo.findByUserName(username));
        LOG.info("user Credentials username:{}" , user.get().getUserName() == null ? null : user.get().getUserName());
        LOG.info("user Credentials password:{}" , user.get().getPassword() == null ? null : user.get().getPassword());
        LOG.info("user Credentials email:{}" , user.get().getEmail() == null ? null : user.get().getEmail());


        if (!user.isPresent()){
            throw new UsernameNotFoundException("User not found for username "+ username);
        }

        JwtUserDetails jwtUser = new JwtUserDetails(user.get().getId(),user.get().getUserName(),user.get().getPassword(),user.get().getRole());

        


        return jwtUser;

    }


}


