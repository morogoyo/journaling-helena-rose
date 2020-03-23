package com.helenarose.webServices.repository;


import com.helenarose.webServices.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAORepository extends JpaRepository<UserDTO,Long> {

    UserDTO findByUserName(String username);
}
