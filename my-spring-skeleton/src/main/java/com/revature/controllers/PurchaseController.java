package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Purchase;
import com.revature.services.PurchaseService;

@CrossOrigin
@RestController
@RequestMapping("purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService ps;
	
	@GetMapping("{id}")
	public List<Purchase> findByCustomerId(@PathVariable int id) {
		System.out.println("Getting Purchases");
		return ps.findByCustomerId(id);
	}
}
