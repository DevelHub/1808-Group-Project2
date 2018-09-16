package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Item_Type;
import com.revature.model.Subscription;
import com.revature.services.Item_TypeService;

@RestController
@RequestMapping("item_type")
public class Item_TypeController {
	
	@Autowired
	private Item_TypeService its;
	
	@PostMapping("add")
	public int save(@RequestBody Item_Type type) {
		System.out.println("Adding item type.");
		return its.save(type);
	}
	
//	@PostMapping
//	public ResponseEntity<Item_Type> save(@RequestBody Item_Type newItem){
//		Item_Type item = its.addItem(newItem);
//		//System.out.println(");
//		
//		return null;
//		
//	}

}
