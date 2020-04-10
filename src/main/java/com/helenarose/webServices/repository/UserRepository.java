package com.helenarose.webServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helenarose.webServices.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long > {

	Users findByFnameAndLname(String fName, String lname);

    Users findByEmail(String email);
}
