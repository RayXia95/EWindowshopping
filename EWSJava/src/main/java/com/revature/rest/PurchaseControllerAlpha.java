package com.revature.rest;

import static com.revature.util.ClientMessageUtil.PURCHASE_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.model.Purchase;
import com.revature.service.PurchaseService;
@Controller("purchaseController")
@CrossOrigin(origins = {"http://localhost:4200"})

public class PurchaseControllerAlpha implements PurchaseController {
	@Autowired
	PurchaseService purchaseService;

	@PostMapping(value="/purchase")
	public @ResponseBody ClientMessage purchaseProduct(@RequestBody Purchase purchase) {
		System.out.println("@@@@@@@@this is in the controller!!!!! "+purchase);
		return (purchaseService.purchaseProduct(purchase) ? PURCHASE_SUCCESSFUL:SOMETHING_WRONG);
	}


}
