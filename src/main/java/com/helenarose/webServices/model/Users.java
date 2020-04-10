package com.helenarose.webServices.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Users implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;


	@Column(name = "email", unique = true)
	private String email;


	@CreationTimestamp
	@Column(name = "createdDate")
	private Date createdDate;
	
	@Column(name = "modifiedDate")
	@UpdateTimestamp
	private Date modifiedDate;
	
	@Column(name = "streetAddress")
	private String streetAddress;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column (name = "zipcode")
	private int zipcode;

	@Temporal(TemporalType.DATE)
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name = "gender")
	private String gender;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UserDTO userDTO;

}
