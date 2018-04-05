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
	private String name;
	
	@Column(name = "P_IMAGE_URL")
	private String image;
	
	@Column(name = "P_PRODUCT_SELLING")
	private long productSelling;
	
	public Product() {}
	
	public Product(long id, String description, String image, long productSelling) {
		this.id = id;
		this.description = description;
		this.image=image;
		this.productSelling = productSelling;
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
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getProductSelling() {
		return productSelling;
	}

	public void setProductSelling(long productSelling) {
		this.productSelling = productSelling;
	}

	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", image=" + image + ", productSelling=" + productSelling + "]";
	}
	
}
