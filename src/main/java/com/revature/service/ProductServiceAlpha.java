package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Selling;
import com.revature.repository.ProductRepository;

@Service("productService")
public class ProductServiceAlpha implements ProductService {
	
	private static Logger logger = Logger.getLogger(ProductServiceAlpha.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Selling> getAllProducts() {
		logger.trace("===================================================================================================");
		logger.trace("========================================In Service===========================================================");
		logger.trace("===================================================================================================");
		return productRepository.findAll();

	}

}
