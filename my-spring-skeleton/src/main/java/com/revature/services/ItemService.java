package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

import com.revature.model.Item;
import com.revature.projections.BasicItemProjection;
import com.revature.repos.ItemRepo;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepo ir;
	
	public int save(Item i){
		return ir.save(i).getId();
	}
	
	
	public List<Item> findAll(){
		return ir.findAll();
	}
	
	public List<Item> findByItemId(int itemId){
		return ir.findById(itemId);
	}
	
	public Item findByCompanyIdAndName(int company_Id, String name){
		return ir.findByCompanyIdAndName(company_Id, name);
	}
	
	public int updateStatus(Item item){
		return ir.saveAndFlush(item).getId();
	}
	
	public int updatePrice(Item item){
		return ir.saveAndFlush(item).getPrice();
	}
	
	public String updateDescription(Item item){
		return ir.saveAndFlush(item).getDescription();
	}
}
