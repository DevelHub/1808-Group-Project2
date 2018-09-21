package com.revature.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.CompanyReviews;
import com.revature.services.CompanyReviewsService;

@CrossOrigin
@RestController
@RequestMapping("company")
public class CompanyReviewsController {

	@Autowired
	private CompanyReviewsService crs;
	
	private List<Integer> messages = new ArrayList<Integer>();
	
	@PostMapping("sendpacket")
	private void sender(@RequestBody CompanyReviews s) {
		messages.add(s.getCustomerId());
	}
	
	@GetMapping("getpackets")
	private List<Integer> receive() {
		return messages;
	}
	
	@PostMapping("review")
	public int save(@RequestBody CompanyReviews cr) {
		System.out.println("Adding Company Review");
		return crs.save(cr);
	}
	
	@GetMapping
	public List<CompanyReviews> findAll() {
		return crs.findAll();
	}
}
