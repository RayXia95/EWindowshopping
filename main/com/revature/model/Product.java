package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EWS_PROD")
public class Product {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "productSequence")
	@SequenceGenerator(name ="productSequence", sequenceName="PRODUCT_SEQ", allocationSize=1)
	@Column(name = "P_ID")
	private int id;
	
	@Column(name = "P_DESC")
	private String description;
	
	@Column(name = "P_COST", nullable=false)
	private double cost;
	
	@Column(name = "P_QUANT", nullable=false)
	private int quantity;
	
	@ManyToOne
	private int userId;
	
	public Product() {}
	public Product(int id, String description, double cost, int quantity, int userId) {
		super();
		this.id = id;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", cost=" + cost + ", quantity=" + quantity
				+ ", userId=" + userId + "]";
	}
	
}
