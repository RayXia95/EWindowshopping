package com.revature.service;

import java.util.List;

import com.revature.model.Product;
import com.revature.model.Purchase;

public interface PurchaseService {
	public boolean purchaseProduct(Purchase purchase);
	List<Purchase> getAllPurchases();
}
