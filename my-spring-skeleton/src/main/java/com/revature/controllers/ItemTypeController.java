package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.ItemType;
import com.revature.services.ItemTypeService;

@CrossOrigin
@RestController
@RequestMapping("item-type")
public class ItemTypeController {

	@Autowired
	private ItemTypeService its;
	
	@GetMapping("{type}")
	public ItemType findByType(@PathVariable String type) {
		return its.findByType(type);
	}
}
