package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Purchase;
import com.revature.repos.PurchaseRepo;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepo pr;
	
	public int save(Purchase p) {
		Purchase purchase = new Purchase();
		purchase.setCustomerId(p.getCustomerId());
		purchase.setDeliveryDate(p.getDeliveryDate());
		purchase.setPurchaseDate(p.getPurchaseDate());
		purchase.setItemId(p.getItemId());
		purchase.setQuantity(p.getQuantity());
		return pr.save(purchase).getId();
	}
	
	public List<Purchase> findByCustomerId(int customerId) {
		return pr.findByCustomerId(customerId);
	}
}
