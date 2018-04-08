package com.revature.repository;

import java.util.List;

import com.revature.model.Product;

public interface ProductRepository {
	
	List<Product> findAll();

}
