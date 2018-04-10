package com.revature.rest;

import java.util.List;

import com.revature.model.Selling;

public interface ProductController {
	List<Selling> findAllProducts();
}
