package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Subscription;
import com.revature.repos.SubscriptionRepo;

@Service
public class SubscriptionService {

	@Autowired
	SubscriptionRepo sr;
	
//	public List<Subscription> saveCustomerSubscription(int customerId, int companyId, int timeFrame) {
//		return sr.saveCustomerSubscription(customerId, companyId, timeFrame);
//	}
}
