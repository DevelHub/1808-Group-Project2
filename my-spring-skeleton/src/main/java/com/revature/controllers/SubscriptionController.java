package com.revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Company;
import com.revature.model.Subscription;
import com.revature.projections.BasicSubscriptionProjection;
import com.revature.services.SubscriptionService;

@CrossOrigin
@RestController
@RequestMapping("subscription")
public class SubscriptionController {

	@Autowired
	SubscriptionService ss;
	
	@PostMapping("add")
	public int save(@RequestBody Subscription s) {
		System.out.println("Adding Subscription");
		return ss.save(s);
	}
	
	@GetMapping("get/{id}")
	public Map<String, Integer> findByCompanyId(@PathVariable int id) {
		System.out.println("Getting Subscriptions");
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<Subscription> subs = ss.findByCompanyId(id);
		map.put(subs.get(0).getCompany().getCompanyName(), subs.size());
		return map;
	}
}
