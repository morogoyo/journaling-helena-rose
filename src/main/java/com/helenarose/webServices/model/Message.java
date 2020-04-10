package com.helenarose.webServices.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;

    @CreationTimestamp
    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "modifiedDate")
    @UpdateTimestamp
    private Date modifiedDate;

//    @ManyToOne
//    @JoinColumn(name = "fk_user")
//    private  Users user;
}

