package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EWS_PRODUCT")
public class Product {

    @Id
    @Column(name = "P_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequence")
    @SequenceGenerator(name = "productSequence", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "P_DESCRIPTION")
    private String description;

    @Column(name = "P_NAME")
    private String productName;

    @Column(name = "P_IMAGE_URL")
    private String image;

    @ManyToOne(cascade=CascadeType.ALL)
    private User seller;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Product product;

    public Product() {}

    public Product(String description, String productName, String image, User seller, Product product) {
        this.description = description;
        this.productName = productName;
        this.image = image;
        this.seller = seller;
        this.product = product;
//>>>>>>> 8d6a55791e82a72eeec7108186a443ec0a63929f
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
    @OneToMany(mappedBy = "product")
    private List<Selling> selling;

    public Product() {
    }

    public Product(long id, String description, String productName, String image, List<Selling> selling) {
	this.id = id;
	this.description = description;
	this.productName = productName;
	this.image = image;
	this.selling = selling;
    }

    public List<Selling> getSelling() {
	return selling;
    }

    public void setSelling(List<Selling> selling) {
	this.selling = selling;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private User seller;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public Product(String description, String productName, String image, User seller, Product product) {
	this.description = description;
	this.productName = productName;
	this.image = image;
	this.seller = seller;
	this.product = product;
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

    public String getProductName() {
	return productName;
    }

    public void setProductName(String productName) {
	this.productName = productName;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
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
	return "Product [id=" + id + ", description=" + description + ", productName=" + productName + ", image="
		+ image + ", selling=" + selling + ", seller=" + seller + ", product=" + product + "]";
    }

}