package com.helenarose.webServices.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helenarose.webServices.webService.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long > {

	Users findByFnameAndLname(String fName, String lname);

}
