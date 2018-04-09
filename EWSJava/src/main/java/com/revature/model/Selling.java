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
@Table(name="EWS_SELLING")
public class Selling {
	
	@Id
	@Column(name="S_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sellingSequence")
	@SequenceGenerator(name="sellingSequence", sequenceName="SELLING_SEQ", allocationSize=1)
	private long id;
	
	@Column(name="S_COST")
	private double cost;
	
	@Column(name="S_QUANTITY")
	private int quantity;
	
	@ManyToOne
	private User seller;
	
	@ManyToOne
	private Product product;
	
	public Selling() {}
	
	public Selling(double cost, int quantity, User seller, Product product) {
		this.cost = cost;
		this.quantity = quantity;
		this.seller = seller;
		this.product = product;
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

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Selling [id=" + id + ", cost=" + cost + ", quantity=" + quantity + ", seller=" + seller + ", product="
				+ product + "]";
	}
}
