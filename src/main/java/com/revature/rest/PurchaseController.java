package com.revature.rest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Purchase;

public interface PurchaseController {
	ClientMessage purchaseProduct(Purchase purchase);
}
