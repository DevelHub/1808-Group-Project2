package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.ItemType;
import com.revature.repos.ItemTypeRepo;

@Service
public class ItemTypeService {

	@Autowired
	private ItemTypeRepo itr;
	
	public ItemType findByType(String type) {
		return itr.findByType(type);
	}
	
	public List<ItemType> findAll() {
		return itr.findAll();
	}
}
