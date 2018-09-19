package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.ItemReviews;
import com.revature.repos.ItemReviewsRepo;

@Service
public class ItemReviewsService {

	@Autowired
	private ItemReviewsRepo irr;
	
	@Transactional
	public int save(ItemReviews ir) {
		return irr.save(ir).getId();
	}
	
	public List<ItemReviews> findByItemId(int itemId) {
		return irr.findByItemId(itemId);
	}
}
