package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.ShoppingCart;
import com.revature.repos.ShoppingCartRepo;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepo scr;
	
	public int save(ShoppingCart sc) {
		return scr.save(sc).getId();
	}
	
	public List<ShoppingCart> findByCustomerId(int customerId) {
		return scr.findByCustomerId(customerId);
	}
}
