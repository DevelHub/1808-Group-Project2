package com.revature.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Company;
import com.revature.model.Subscription;
import com.revature.services.CompanyService;
import com.revature.services.SubscriptionService;

@CrossOrigin
@RestController
@RequestMapping("subscription")
public class SubscriptionController {

	@Autowired
	SubscriptionService ss;
	
	@Autowired
	CompanyService cs;
	
	@PostMapping("add")
	public int save(@RequestBody Subscription s) {
		System.out.println("Adding Subscription");
		return ss.save(s);
	}
	
	@GetMapping
	public List<Map<String, Object>> findTotalSubs() {
		System.out.println("Getting Number of Subscriptions by Company");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Company> companies = cs.findAll();
		int numberOfCompanies = companies.size();
		for (int i = 0; i < numberOfCompanies; i++) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				List<Subscription> subs = ss.findByCompanyId(i);
				String companyName = subs.get(0).getCompany().getCompanyName();
				map.put("name", companyName);
				map.put("total", subs.size());
				list.add(map);
			} catch(IndexOutOfBoundsException ex) {
				System.out.println("No Subscriptions");
			}
		}
		return list;
	}
}
