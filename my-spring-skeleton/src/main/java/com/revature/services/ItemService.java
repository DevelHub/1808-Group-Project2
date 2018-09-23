package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Item;
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
	
	public Item findById(int id){
		return ir.findById(id);
	}
	
	public Item findByCompanyIdAndName(int company_Id, String name){
		return ir.findByCompanyIdAndName(company_Id, name);
	}
	
	public Item findByIdAndName(int id, String name){
		return ir.findByIdAndName(id, name);
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
	
	public List<Item> findByCompanyId(int id) {
		return ir.findByCompanyId(id);
	}
}