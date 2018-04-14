package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Purchase;
import com.revature.model.Selling;
import com.revature.model.User;
import com.revature.repository.PurchaseRepository;
@Repository("purchaseService")
public class PurchaseServiceAlpha implements PurchaseService{
	
	@Autowired
	PurchaseRepository purchaseRepository;

	@Override
	public boolean purchaseProduct(Purchase purchase) {
		// Unpacking some variables from purchase
		User seller = purchase.getSelling().getSeller();
		User buyer = purchase.getBuyer();
		Selling selling = purchase.getSelling();

		if (buyer.getBalance() < selling.getCost()) {
			// To expensive for buyer
			return false;
		} else if (purchase.getQuantity() > selling.getQuantity()) {
			// Not enough in stock
			return false;
		} else {
			double balanceChange = purchase.getQuantity() * selling.getCost();
			buyer.setBalance(buyer.getBalance() - balanceChange);
			seller.setBalance(seller.getBalance() + balanceChange);

			selling.setQuantity(selling.getQuantity() - purchase.getQuantity());

			purchaseRepository.save(purchase);
			return purchase.getBuyer().getId() != 0;
		}	
	}

	@Override
	public List<Purchase> getAllPurchases() {
		return purchaseRepository.findAll();
	}

}
