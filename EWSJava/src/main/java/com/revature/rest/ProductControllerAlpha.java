package com.revature.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Selling;
import com.revature.service.ProductService;

@Controller("productController")
@CrossOrigin(origins={"http://localhost:4200"})
public class ProductControllerAlpha implements ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/getAllProducts")
	public @ResponseBody List<Selling> findAllProducts() {
		return productService.getAllProducts();
	}
}
