package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Item;
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
	
//	public List<Item> buildRecomendation(int customerId) {
//		List<Purchase> listOfPurchases = pr.findByCustomerId(customerId);
//		List<Item> listOfItems = new ArrayList<Item>();
//		listOfPurchases.get(0).getItemId();
//		if(listOfPurchases.isEmpty()) {
//			return null;
//		}
//		else {
//			
//		}
//	}
}
