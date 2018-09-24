package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Item;
import com.revature.model.Purchase;
import com.revature.services.PurchaseService;

@CrossOrigin
@RestController
@RequestMapping("purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService ps;
	
	@PostMapping
	public int save(@RequestBody Purchase p) {
		return ps.save(p);
	}
	
	@GetMapping("{customerId}")
	public List<Purchase> findByCustomerId(@PathVariable int customerId) {
		System.out.println("Getting Purchases");
		return ps.findByCustomerId(customerId);
	}

	@GetMapping("recomendation/{customerId}")
	public List<List<Item>> buildRecomendation(@PathVariable int customerId) {
		System.out.println("Building Recomendations");
		return ps.buildRecomendation(customerId);
	}
}
