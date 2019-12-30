package com.helenarose.webServices.webService.model;

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
    @GeneratedValue
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

    @ManyToOne
    private  Users user;
}
