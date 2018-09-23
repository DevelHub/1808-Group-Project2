package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	List<Item>findAll();
	
	Item findByCompanyIdAndName(int companyId, String name);
	Item findByIdAndName(int id, String name);
	
	Item findById(int id);
    
	List<Item> findByCompanyId(int id);
    
}