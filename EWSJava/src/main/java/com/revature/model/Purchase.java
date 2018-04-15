package com.revature.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EWS_PURCHASE")
public class Purchase {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="purchaseSequence")
	@SequenceGenerator(name="purchaseSequence",sequenceName="PURCHASE_SEQ",allocationSize=1)
	@Column(name="PC_ID")
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PC_TIME")
	private Date time;
	
	@Column(name="PC_QUANTITY")
	private int quantity;

	@ManyToOne(cascade=CascadeType.ALL)
	private User buyer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Selling selling;

	public Purchase() {}	
	
	public Purchase(Date time, int quantity, User buyer, Selling selling) {
		this.time = time;
		this.quantity = quantity;
		this.buyer = buyer;
		this.selling = selling;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Selling getSelling() {
		return selling;
	}

	public void setSelling(Selling selling) {
		this.selling = selling;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", time=" + time + ", quantity=" + quantity + ", buyer=" + buyer + ", selling="
				+ selling + "]";
	}
}