package com.revature.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Customer;
import com.revature.projections.BasicCustomerProjection;
import com.revature.services.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	@GetMapping
	public List<Customer> findAll() {
		return cs.findAll();
	}
	
	@PostMapping
	public int save(@RequestBody Customer c) {
		return cs.save(c);
	}

	@GetMapping("age")
	public List<BasicCustomerProjection> findAllProjectedBy() {
		System.out.println("finding all users");
		return cs.findAllProjectedBy();
	}

}
