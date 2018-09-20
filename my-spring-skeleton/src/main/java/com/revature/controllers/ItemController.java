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
import com.revature.model.Subscription;
import com.revature.services.ItemService;

@CrossOrigin
@RestController
@RequestMapping("item")
public class ItemController {
    
    @Autowired
    ItemService is;
    
//    find out how to update an entity in java spring
    
//    @PostMapping("status")
//    public String save(@RequestBody Item item){
//        return is.save(item);
//    }
//    
    @GetMapping
    public List<Item> findAll() {
        return is.findAll();
        
    }
    
//    @GetMapping("{companyId}")
//    public List<Item> findByCompanyId(@PathVariable int companyId){
//        return is.findByCompanyId(companyId);
//    }
    
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
    
    //company find and items
//	@GetMapping
//	public List<Map<String, Object>> findByCompanyId() {
//		System.out.println("Getting Subscriptions");
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		try {
//			int index = 1;
//			while(true) {
//				Map<String, Object> map = new HashMap<String, Object>();
//				List<Subscription> subs = ss.findByCompanyId(index++);
//				String companyName = subs.get(0).getCompany().getCompanyName();
//				map.put("name", companyName);
//				map.put("total", subs.size());
//				list.add(map);
//			}
//		} catch(IndexOutOfBoundsException ex) {
//			System.out.println("Exception caught");
//		}
//		return list;
//	}
    
}