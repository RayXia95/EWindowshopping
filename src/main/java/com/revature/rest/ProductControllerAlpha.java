package com.revature.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Product;
import com.revature.service.ProductService;

@Controller("ProductController")
public class ProductControllerAlpha implements ProductController {
	
	private static Logger logger = Logger.getLogger(ProductControllerAlpha.class);
	@Autowired
	private ProductService productService;
	
	@GetMapping("/findAllHeroes")
	public @ResponseBody List<Product> findAllProducts() {
		return productService.getAllProducts();
	}

}
