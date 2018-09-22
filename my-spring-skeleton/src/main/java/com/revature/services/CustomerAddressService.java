package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.CustomerAddress;
import com.revature.repos.CustomerAddressRepo;

@Service
public class CustomerAddressService {

	@Autowired
	CustomerAddressRepo car;
	
	public int save(int customerId, int addressId) {
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setAddressId(addressId);
		customerAddress.setCustomerId(customerId);
		return car.save(customerAddress).getCustomerId();
	}
}
