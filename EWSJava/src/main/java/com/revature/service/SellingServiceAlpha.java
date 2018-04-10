package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Selling;
import com.revature.repository.SellingRepository;
@Repository("sellingService")
public class SellingServiceAlpha implements SellingService {

	@Autowired
	SellingRepository sellingRepository;
	@Override
	public boolean sellProduct(Selling selling) {
		sellingRepository.save(selling);
		return selling.getSeller().getId()!=0;
	}

}
