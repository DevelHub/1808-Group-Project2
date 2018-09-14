package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Subscription;
import com.revature.projections.BasicSubscriptionProjection;
import com.revature.repos.SubscriptionRepo;

@Service
public class SubscriptionService {

	@Autowired
	SubscriptionRepo sr;
	
	public int save(Subscription s) {
		return sr.save(s).getId();
	}
	
	public List<BasicSubscriptionProjection> findByCompanyId(int id) {
		return sr.findByCompanyId(id);
	}
}
