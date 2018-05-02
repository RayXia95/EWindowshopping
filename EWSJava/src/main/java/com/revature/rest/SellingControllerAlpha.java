package com.revature.rest;

import static com.revature.util.ClientMessageUtil.SELL_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.model.Selling;
import com.revature.service.SellingService;
@Controller("sellingController")
@CrossOrigin(origins= {"http://localhost:4200"})
public class SellingControllerAlpha implements SellingController {

	@Autowired
	SellingService sellingService;

	@PostMapping(value="/selling")
	public @ResponseBody ClientMessage sellingProduct(@RequestBody Selling selling) {
		return (sellingService.sellProduct(selling) ? SELL_SUCCESSFUL:SOMETHING_WRONG);
	}

}
