package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.credential.Credentials;
import com.revature.model.Customer;
import com.revature.repos.CredentialsRepo;

@Service
public class CredentialService {

	@Autowired
	CredentialsRepo cr;
	
	@Autowired
	CustomerService cs;
	
	public int save(Credentials c) {
		Credentials cred = new Credentials();
		cred.setUsername(c.getUsername());
		cred.setPassword(c.getPassword());
		cred.setRole("Customer");
		int credId = cr.save(cred).getId();
		Customer customer = c.getCustomer();
		customer.setId(credId);
		return cs.save(customer);
	}
	
	public List<Credentials> findByUsernameAndPassword(String username, String password) {
		return cr.findByUsernameAndPassword(username, password);
	}
	
}
