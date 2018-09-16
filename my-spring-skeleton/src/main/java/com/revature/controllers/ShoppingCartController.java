package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.ShoppingCart;
import com.revature.services.ShoppingCartService;

@CrossOrigin
@RestController
@RequestMapping("cart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService scs;
	
	@PostMapping("add")
	public int save(@RequestBody ShoppingCart sc) {
		return scs.save(sc);
	}
	
	@GetMapping("get/{customerId}")
	public List<ShoppingCart> findByCustomerId(@PathVariable int customerId) {
		return scs.findByCustomerId(customerId);
	}
}
