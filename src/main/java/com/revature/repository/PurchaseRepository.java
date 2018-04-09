package com.revature.repository;

import java.util.List;

import com.revature.model.Purchase;

public interface PurchaseRepository {
	public void save(Purchase purchase);
	public List<Purchase> findAll();
}
