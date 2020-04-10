package com.helenarose.webServices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BcryptEncoderTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("password");
        System.out.println(encodedPassword);



    }
}
