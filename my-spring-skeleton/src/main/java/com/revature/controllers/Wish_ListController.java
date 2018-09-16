package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Wish_List;
import com.revature.services.Wish_ListService;

@CrossOrigin
@RestController
@RequestMapping("wishlist")
public class Wish_ListController {
	
	@Autowired
	Wish_ListService ws;
	
	@PostMapping("add")
	public int save(@RequestBody Wish_List list) {
		System.out.println("Adding to wishlist.");
		return ws.save(list);
	}
	
	
	
	

}
