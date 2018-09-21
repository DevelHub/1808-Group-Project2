package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Address;
import com.revature.repos.AddressRepo;

@Service
public class AddressService {

	@Autowired
	private AddressRepo ar;
	
	public int save(Address a) {
		Address address = new Address();
		address.setUserId(a.getUserId());
		address.setType(a.getType());
		address.setCity(a.getCity());
		address.setState(a.getState());
		address.setZip(a.getZip());
		address.setCountry(a.getCountry());
		return ar.save(address).getId();
	}
}
