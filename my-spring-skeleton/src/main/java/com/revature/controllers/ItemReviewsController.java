package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.ItemReviews;
import com.revature.services.ItemReviewsService;

@RestController
@RequestMapping("review")
public class ItemReviewsController {

	@Autowired
	private ItemReviewsService irs;
	
	@PostMapping("item")
	public int save(ItemReviews i) {
		return irs.save(i);
	}
}
