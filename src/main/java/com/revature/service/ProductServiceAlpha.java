package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Selling;
import com.revature.repository.ProductRepository;

@Service("productService")
public class ProductServiceAlpha implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Selling> getAllProducts() {
		
		return productRepository.findAll();

	}

}
