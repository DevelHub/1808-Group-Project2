package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Item_Type;
import com.revature.model.Subscription;
import com.revature.repos.Item_TypeRepo;

@Service
public class Item_TypeService {
	@Autowired
	private Item_TypeRepo itr;
	
	public int save(Item_Type type) {
		return itr.save(type).getItem_type_id();
	}
	
	public Item_Type addItem(Item_Type type) {
		return itr.save(type);
	}
}
