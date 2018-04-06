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
@Table(name = "EWS_PRODUCT")
public class Product {

	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "productSequence")
	@SequenceGenerator(name ="productSequence", sequenceName="PRODUCT_SEQ", allocationSize=1)
	private long id;

	@Column(name = "P_DESCRIPTION")
	private String description;

	@Column(name = "P_NAME")
	private String productName;

	@Column(name = "P_IMAGE_URL")
	private String image;

	@OneToMany(mappedBy= "EWS_PURCHASE")
	private List<Purchase> purchase;

	@OneToMany(mappedBy = "EWS_SELLING")
	private List<Selling> selling;

	public Product() {}
	
	public Product(long id, String description, String productName, String image, List<Purchase> purchase,
			List<Selling> selling) {
		this.id = id;
		this.description = description;
		this.productName = productName;
		this.image = image;
		this.purchase = purchase;
		this.selling = selling;
	}

	public List<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}

	public List<Selling> getSelling() {
		return selling;
	}

	public void setSelling(List<Selling> selling) {
		this.selling = selling;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", productName=" + productName + ", image="
				+ image + ", purchase=" + purchase + ", selling=" + selling + "]";
	}

}