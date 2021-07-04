package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Email;
import com.revature.model.Purchase;
import com.revature.model.Selling;
import com.revature.model.User;
import com.revature.repository.PurchaseRepository;
import com.revature.repository.SellingRepository;
import com.revature.repository.UserRepository;
@Repository("purchaseService")
public class PurchaseServiceAlpha implements PurchaseService{
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SellingRepository sellingRepository;
	

	@Override
	public boolean purchaseProduct(Purchase purchase) {
		// Unpacking some variables from purchase
		System.out.println("!!!!!!!!!"+purchase);
		User seller = purchase.getSelling().getSeller();
		User buyer = purchase.getBuyer();
		Selling selling = purchase.getSelling();

//		if (buyer.getBalance() < selling.getCost()) {
//			// To expensive for buyer
//			return false;
//		} else if (purchase.getQuantity() > selling.getQuantity()) {
//			// Not enough in stock
//			return false;
//		} else {
			double balanceChange = purchase.getQuantity() * selling.getCost();
			buyer.setBalance(buyer.getBalance() - balanceChange);
			seller.setBalance(seller.getBalance() + balanceChange);
			selling.setQuantity(selling.getQuantity() - purchase.getQuantity());

			//Updating the database with changes
			userRepository.update(buyer);
			userRepository.update(seller);
			sellingRepository.update(selling);
			purchaseRepository.save(purchase);
			String subject="Order confirmation";
			String email=purchase.getBuyer().getEmail();
			String body="Your order of "+ purchase.getSelling().getProduct().getProductName()+" has been received!"+"";
			Email mail= new Email(subject,body,email);
			Thread send = new Thread(mail);
			send.start();
			return purchase.getBuyer().getId() != 0;
		}	
	//}

	@Override
	public List<Purchase> getAllPurchases() {
		return purchaseRepository.findAll();
	}

}