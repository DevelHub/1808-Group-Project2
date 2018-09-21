package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.credential.Credentials;
import com.revature.model.Customer;
//import com.revature.services.
import com.revature.services.CredentialService;

@CrossOrigin
@RestController
@RequestMapping("credential")
public class CredentialController{

	@Autowired
	CredentialService cs;

	@PostMapping
	public int save(@RequestBody Credentials c) {
		return cs.save(c);
	}
	
	@PostMapping("login")
	public List<Credentials> findByUsernameAndPassword(@RequestBody Credentials c) {
		System.out.println("Login Called");
		return cs.findByUsernameAndPassword(c.getUsername(), c.getPassword());
	}
	
//	@PostMapping("signup")
//	public int save(@RequestBody Credentials c) {
//		System.out.println("Signup Called");
//		Customer customer = new Customer();
//		customer.setFirstname(c.getCustomer().getFirstname());
//		customer.setLastname(c.getCustomer().getLastname());
//		return cse.saveAndFlush(customer);
//	}
}
