package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EWS_USER")
public class User {
	
	@Id
	@Column(name="U_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="HERO_SEQ", allocationSize=1)
	private long id;
	
	@Column(name="U_USERNAME", nullable=false, unique=true)
	private String username;
	
	@Column(name="U_FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="U_LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="U_PASSWORD", nullable=false)
	private String password;
	
	@Column(name="U_BALANCE", nullable=false)
	private double balance;
		
	@Column(name="U_STREET", nullable=false)
	private String street;
	
	@Column(name="U_TOWN", nullable=false)
	private String town;

	@Column(name="U_STATE", nullable=false)
	private String state;
	
	@Column(name="PC_ID")
	@ManyToMany
	public List<Purchase> purchases;
	
	@Column(name="S_ID")
	@ManyToMany
	public List<Selling> sold;
	
	@Column(name="U_ZIP_CODE", nullable=false)
	private String zipCode;

	public User() {	}

	
	
}
