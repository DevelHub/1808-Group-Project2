package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Address;
import com.revature.model.Customer;
import com.revature.projections.BasicCustomerProjection;
import com.revature.repos.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo cr;
	
	@Autowired
	private AddressService ac;
	
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
		Address address;
		for (int i = 0; i < 2; i++) {
			address = c.getAddress().get(i);
			address.setUserId(c.getId());
			ac.save(address);
		}
		return cr.save(customer).getId();
	}
	
	public int saveAndFlush(Customer c) {
		return cr.saveAndFlush(c).getId();
	}

	public List<BasicCustomerProjection> findAllProjectedBy() {
		return cr.findAllProjectedBy();
	}
}
