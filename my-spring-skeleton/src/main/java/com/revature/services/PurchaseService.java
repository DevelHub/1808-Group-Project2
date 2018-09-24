package com.revature.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Item;
import com.revature.model.Purchase;
import com.revature.repos.ItemRepo;
import com.revature.repos.PurchaseRepo;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepo pr;

	@Autowired
	private ItemRepo ir;
	
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
	
	public List<List<Item>> buildRecomendation(int customerId) {
		List<Purchase> listOfPurchases = pr.findByCustomerId(customerId);
		List<List<Item>> recommendedItems = new ArrayList<List<Item>>();
		if(listOfPurchases.isEmpty()) {
			return null;
		}
		else {
			Random ran = new Random();
			List<Item> items = ir.findAll();
			int count = items.size() / listOfPurchases.size();
			int index = 0;
			while(true) {
				try {
					List<Item> nextItems = new ArrayList<Item>();
					for(int i = index; i < index + count; i++) {
						nextItems.add(items.get(i));
					}
					int sub = ran.nextInt(listOfPurchases.size());
					String itemDescription = listOfPurchases.get(sub).getItem().getDescription();
					String itemGender = listOfPurchases.get(sub).getItem().getGender();
					double itemPrice = listOfPurchases.get(sub).getItem().getPrice();
					String[] splitItemDescription = itemDescription.split(" ");
					int randomIndex = ran.nextInt(splitItemDescription.length);
					List<Item> temp = nextItems.stream()
							.filter(itemIndex -> 
								(itemIndex.getDescription().contains(splitItemDescription[randomIndex]))
								&& (itemIndex.getGender().equalsIgnoreCase(itemGender))
								&& (isClose(itemIndex.getPrice(), itemPrice)))
							.collect(Collectors.toList());
					if(!temp.isEmpty())
						recommendedItems.add(temp);
					index += count;
				} catch (IndexOutOfBoundsException ex) {
					System.out.println("Index Out of Bounds!");
					break;
				}
			}
		}
		return recommendedItems;
	}
	
	public boolean isClose(double itemIndex, double itemPrice) {
		double offSet = 10.0;
		if(itemIndex >= (itemPrice - offSet) || (itemIndex > itemPrice && itemIndex <= (itemPrice + offSet))) {
			return true;
		}
		return false;
	}
}
