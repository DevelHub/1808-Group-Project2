//package com.revature.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.revature.credential.Credentials;
//import com.revature.model.Customer;
//import com.revature.repos.CredentialsRepo;
//
//@Service
//public class CredentialService {
//
//	@Autowired
//	CredentialsRepo cr;
//	
//	
//	public List<Credentials> findByUsernameAndPassword(String username, String password) {
//		return cr.findByUsernameAndPassword(username, password);
//	}
//	
//	public int save(Credentials c) {
//		Credentials cred = new Credentials();
//		cred.setUsername(c.getUsername());
//		cred.setPassword(c.getPassword());
//		cred.setRole(c.getRole());
//		return cr.save(cred).getId();
//	}
//}
