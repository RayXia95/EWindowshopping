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
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "productSequence")
	@SequenceGenerator(name ="productSequence", sequenceName="PRODUCT_SEQ", allocationSize=1)
	@Column(name = "P_ID")
	private int id;
	
	@Column(name = "P_DESCRIPTION")
	private String description;
	
	@Column(name = "P_IMAGE_URL")
	private String image;
	
	@ManyToOne
	private int sId;
	
	public Product() {}
	public Product(int id, String description, String image, int userId) {
		super();
		this.id = id;
		this.description = description;
		this.image=image;
		this.sId = userId;
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
	public int getUserId() {
		return sId;
	}
	public void setUserId(int userId) {
		this.sId = userId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", image=" + image + ", sId=" + sId + "]";
	}

	
}
