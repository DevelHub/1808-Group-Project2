package com.revature.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping
    public List<Item> findAll() {
        return is.findAll();
    }
    
    @GetMapping("{itemId}")
    public List<Item> findByItemId(@PathVariable int itemId){
        return is.findByItemId(itemId);
    }
    
    @PatchMapping("updateStatus")
    public ResponseEntity<Item> update(@RequestBody Item aItem){
        Item isc = is.findByCompanyIdAndName(aItem.getCompanyId(), aItem.getName());
        isc.setStatus(aItem.getStatus());
        ResponseEntity<Item> response = new ResponseEntity<Item>(isc, HttpStatus.CREATED);
        return response;
    }
    
	@GetMapping("total")
	public List<Map<String, Object>> findTotalItemsOfCompany() {
		System.out.println("Getting Number of Items by Company");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			int index = 1;
			while(true) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<Item> items = is.findByCompanyId(index++);
				String companyName = items.get(0).getCompany().getCompanyName();
				map.put("name", companyName);
				map.put("total", items.size());
				list.add(map);
			}
		} catch(IndexOutOfBoundsException ex) {
			System.out.println("Exception Caught");
		}
		return list;
	}
    
}