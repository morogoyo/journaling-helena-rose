package com.helenarose.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helenarose.model.Users;

public interface UserRepository extends JpaRepository<Users, Long > {	

}
