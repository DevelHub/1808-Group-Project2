package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Subscription;
import com.revature.services.SubscriptionService;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {

	@Autowired
	SubscriptionService ss;
//	
	@PostMapping("addSub")
	public ResponseEntity<Subscription> saveCustomerSubscription(@RequestBody Subscription s) {
		System.out.println("Adding Subscription");
		s.setCompanyId(1);
		s.setCustomerId(1);
		s.setTimeFrame(1);
		ResponseEntity<Subscription> re = new ResponseEntity<Subscription>(s, HttpStatus.CREATED);
		return re;
	}
//	@PostMapping("sub")
//	public ResponseEntity<Subscription> save(@RequestBody Subscription u) {
//		u.setId(1);
//		u.setcustomerId(1);
//		u.setTimeFrame(1);
//		ResponseEntity<Subscription> re = new ResponseEntity<Subscription>(ss., HttpStatus.CREATED);
//		return re;
//	}
}
