package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.ItemReviews;
import com.revature.services.ItemReviewsService;

@CrossOrigin
@RestController
@RequestMapping("item-review")
public class ItemReviewsController {

	@Autowired
	private ItemReviewsService irs;
	
	@PostMapping
	public int save(@RequestBody ItemReviews ir) {
		return irs.save(ir);
	}
	
	@GetMapping("{itemId}")
	public List<ItemReviews> findByItemId(@PathVariable int itemId) {
		return irs.findByItemId(itemId);
	}
}
