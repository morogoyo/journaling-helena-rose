package com.helenarose.webServices.model;


import lombok.*;
import org.hibernate.annotations.NaturalId;

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


    @Column(name = "id")
    private Long id;

    @Column(name="username")
    private String userName;

    @Column(name ="password")
    private String password;

    @Column(name ="role")
    private String role;

    @Id
    @Column(name ="email")
    private String email;

    @OneToOne(mappedBy = "userDTO", cascade = CascadeType.ALL)
    private Users user;



}
