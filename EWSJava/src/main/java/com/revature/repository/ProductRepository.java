package com.revature.repository;

import java.util.List;

import com.revature.model.Selling;

public interface ProductRepository {
	List<Selling> findAll();
}
