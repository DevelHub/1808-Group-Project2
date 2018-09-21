package com.revature.controllers;

import java.io.*;
import java.net.*;
import java.util.*;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

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
	
//	private static InetAddress host;
//	private final int OUTPORT = 1241;
//	private final int INPORT = 1242;
	private List<Integer> messages = new ArrayList<Integer>();
	
	@PostMapping("sendpacket")
	private void sender(@RequestBody CompanyReviews s) {
		messages.add(s.getCustomerId());
	}
//	
	@GetMapping("getpackets")
	private List<Integer> receive() {
		return messages;
	}
//	
//	private void delay() {
//		try {
//			TimeUnit.SECONDS.sleep(0);
//		} catch (InterruptedException ie) {
//			System.out.println("Delay failure");
//		}
//	}
	
	@PostMapping("review")
	public int save(@RequestBody CompanyReviews cr) {
		System.out.println("Adding Company Review");
		return crs.save(cr);
	}
	
	@GetMapping
	public List<CompanyReviews> findAll() {
		return crs.findAll();
	}
	
//	@GetMapping("{companyId}")
//	public List<CompanyReviews> findByCompanyId(@PathVariable int companyId) {
//		return crs.findByCompanyId(companyId);
//	}
//	
//	@PatchMapping("review-update")
//	public ResponseEntity<CompanyReviews> update(@RequestBody CompanyReviews cr) {
//		CompanyReviews ctr = crs.findByCompanyId(cr.getCompanyId()).get(0);
//		ctr.setReview(cr.getReview());
//		crs.update(ctr);
//		ResponseEntity<CompanyReviews> re = new ResponseEntity<CompanyReviews>(ctr, HttpStatus.CREATED);
//		return re;
//	}
	
}
