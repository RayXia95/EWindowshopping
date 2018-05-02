package com.revature.rest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Selling;

public interface SellingController {
	ClientMessage sellingProduct(Selling selling);
}
