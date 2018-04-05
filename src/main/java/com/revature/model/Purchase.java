package com.revature.model;

import java.util.Date;

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

	@ManyToOne
	@Column(name="U_ID")
	private User buyer;
	
	@ManyToOne
	@Column(name="P_ID")
	private Product product;

	public Purchase() {}
	
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", time=" + time + ", quantity=" + quantity + ", buyer=" + buyer + ", product="
				+ product + "]";
	}
}
