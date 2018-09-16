package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Item;
import com.revature.services.ItemService;

@CrossOrigin
@RestController
@RequestMapping("item")
public class ItemController {
	
	@Autowired
	ItemService is;
	
	//allow for the company to add an item.
	@PostMapping("add")
	public int save(@RequestBody Item item){
		System.out.println("Adding an item.");
		return is.save(item);
	}
	
	//find all items in the DB.
	@GetMapping
	public List<Item> findAll() {
		return is.findAll();
		
	}
	

	//find a specific item by ID.
	@GetMapping("{itemId}")
	public List<Item> findByItemId(@PathVariable int itemId){
		return is.findByItemId(itemId);
	}
	
	//update the status of an item by obtaining the company id and name of the item
	//isc : item status change
	@PatchMapping("updatestatus")
	public ResponseEntity<Item> update(@RequestBody Item aItem){
		Item isc = is.findByCompanyIdAndName(aItem.getCompanyId(), aItem.getName());
		isc.setStatus(aItem.getStatus());
		is.save(isc);
		ResponseEntity<Item> response = new ResponseEntity<Item>(isc, HttpStatus.CREATED);
		return response;
	}
	
	//update the price of an item by obtaining the company id and name of the item .
	//ipc : item price change
	@PatchMapping("updateprice")
	public ResponseEntity<Item> updatePrice(@RequestBody Item item){
		Item ipc = is.findByCompanyIdAndName(item.getCompanyId(), item.getName());
		ipc.setPrice(item.getPrice());
		is.save(ipc);
		ResponseEntity<Item> response = new ResponseEntity<Item>(ipc, HttpStatus.CREATED);
		return response;
	}
	
	@PatchMapping("updatedescription")
	public ResponseEntity<Item> updateDescription(@RequestBody Item item){
		Item idc = is.findByCompanyIdAndName(item.getCompanyId(), item.getName());
		idc.setDescription(item.getDescription());
		is.save(idc);
		ResponseEntity<Item> response = new ResponseEntity<Item>(idc, HttpStatus.CREATED);
		return response;
	}
	
}
