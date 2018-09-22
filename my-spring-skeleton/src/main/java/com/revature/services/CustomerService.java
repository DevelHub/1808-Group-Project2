package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Address;
import com.revature.model.Customer;
import com.revature.model.CustomerAddress;
import com.revature.projections.BasicCustomerProjection;
import com.revature.repos.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo cr;
	
	@Autowired
	private AddressService ac;
	
	@Autowired
	private CustomerAddressService cas;
	
	public int save(Customer c) {
		Customer customer = new Customer();
		customer.setUserId(c.getId());
		customer.setFirstname(c.getFirstname());
		customer.setLastname(c.getLastname());
		customer.setAge(c.getAge());
		customer.setCardNumber(c.getCardNumber());
		customer.setGender(c.getGender());
		customer.setDateOfBirth(c.getDateOfBirth());
		customer.setEthnicity(c.getEthnicity());
		int customerId = cr.save(customer).getId();
		Address address;
		CustomerAddress customerAddress = new CustomerAddress();
		for (int i = 0; i < 2; i++) {
			address = c.getAddress().get(i);
			address.setUserId(c.getId());
			int addressId = ac.save(address);
			customerAddress.setCustomerId(customerId);
			customerAddress.setAddressId(addressId);
			System.out.println("CUSTOMER ID: " + customerId + "ADDRESS ID: " + addressId);
			cas.save(customerId, addressId);
		}
		return customerId;
	}
	
	public int saveAndFlush(Customer c) {
		return cr.saveAndFlush(c).getId();
	}

	public List<BasicCustomerProjection> findAllProjectedBy() {
		return cr.findAllProjectedBy();
	}
}
