package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Purchase;
import com.revature.repos.PurchaseRepo;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepo pr;
	
	public List<Purchase> findByCustomerId(int customerId) {
		return pr.findByCustomerId(customerId);
	}
}
