package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Address;
import com.revature.services.AddressService;

@RestController
@RequestMapping("address")
public class AddressController {

	@Autowired
	private AddressService as;
	
	@PostMapping
	public int save(@RequestBody Address a) {
		return as.save(a);
	}
}
