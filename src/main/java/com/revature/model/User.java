package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EWS_USER")
public class User {
	
	@Id
	@Column(name="U_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	private long id;
	
	@Column(name="U_USERNAME", nullable=false)
	private String username;
	
	@Column(name="U_FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="U_LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="U_PASSWORD", nullable=false)
	private String password;
	
	@Column(name="U_EMAIL", nullable=false, unique=true )
	private String email;
	
	@Column(name="U_BALANCE", nullable=false)
	private double balance;
	
	@Column(name="U_STREET", nullable=false)
	private String street;
	
	@Column(name="U_TOWN", nullable=false)
	private String town;

	@Column(name="U_STATE", nullable=false)
	private String state;
	
	@Column(name="U_ZIP_CODE", nullable=false)
	private String zipCode;

	@OneToMany(mappedBy= "seller")
	@Column(name="S_ID")
	private List<Selling> productsSold;
	
	@OneToMany(mappedBy= "buyer")
	@Column(name="PC_ID")
	private List<Selling> productsPurchased;

	public User() {	}

	public User(String username, String firstName, String lastName, String password, String email, double balance,
			String street, String town, String state, String zipCode, List<Selling> productsSold,
			List<Selling> productsPurchased) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.balance = balance;
		this.street = street;
		this.town = town;
		this.state = state;
		this.zipCode = zipCode;
		this.productsSold = productsSold;
		this.productsPurchased = productsPurchased;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Selling> getProductsSold() {
		return productsSold;
	}

	public void setProductsSold(List<Selling> productsSold) {
		this.productsSold = productsSold;
	}

	public List<Selling> getProductsPurchased() {
		return productsPurchased;
	}

	public void setProductsPurchased(List<Selling> productsPurchased) {
		this.productsPurchased = productsPurchased;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", email=" + email + ", balance=" + balance + ", street=" + street
				+ ", town=" + town + ", state=" + state + ", zipCode=" + zipCode + ", productsSold=" + productsSold
				+ ", productsPurchased=" + productsPurchased + "]";
	}
	
}
