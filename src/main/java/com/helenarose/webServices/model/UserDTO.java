package com.helenarose.webServices.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class UserDTO  implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name="username")
    private String userName;

    @Column(name ="password")
    private String password;

    @Column
    private String role;

    @Column
    private String email;

    @OneToOne(mappedBy = "userDTO", cascade = CascadeType.ALL)
    private Users user;



}
