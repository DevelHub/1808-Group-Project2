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
    
    public String save(Item i){
        return ir.save(i).getStatus();
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
	
	public List<Item> findByCompanyId(int id) {
		return ir.findByCompanyId(id);
	}
    
}