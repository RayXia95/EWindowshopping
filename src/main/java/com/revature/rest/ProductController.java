package com.revature.rest;

import java.util.List;

import com.revature.model.Product;

public interface ProductController {
	
	List<Product> findAllProducts();
}
