package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.ItemReviews;
import com.revature.repos.ItemReviewsRepo;

@Service
public class ItemReviewsService {

	@Autowired
	private ItemReviewsRepo irr;
	
	public int save(ItemReviews i) {
		return irr.save(i).getId();
	}
}
