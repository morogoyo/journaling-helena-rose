package com.helenarose.webServices.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class UserDTO {

    Long id;
    String userName;
    String password;
}
