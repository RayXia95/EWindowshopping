package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Purchase;
import com.revature.repository.PurchaseRepository;
@Repository("purchaseService")
public class PurchaseServiceAlpha implements PurchaseService{
	
	@Autowired
	PurchaseRepository purchaseRepository;

	@Override
	public boolean purchaseProduct(Purchase purchase) {
			purchaseRepository.save(purchase);
			return purchase.getBuyer().getId()!=0;
	}

	@Override
	public List<Purchase> getAllPurchases() {
		return purchaseRepository.findAll();
	}

}
