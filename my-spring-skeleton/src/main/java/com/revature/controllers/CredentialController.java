//package com.revature.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.credential.Credentials;
//import com.revature.model.Customer;
////import com.revature.services.
//import com.revature.services.CredentialService;
//import com.revature.services.CustomerService;
//
//@CrossOrigin
//@RestController
//@RequestMapping("credential")
//public class CredentialController{
//
//	@Autowired
//	CredentialService cs;
//	
//	@Autowired
//	CustomerService cse;
//	
//	private Credentials c;
//	
//	@PostMapping("login")
//	public List<Credentials> findByUsernameAndPassword(@RequestBody Credentials c) {
//		System.out.println("Login Called");
//		return cs.findByUsernameAndPassword(c.getUsername(), c.getPassword());
//	}
//	
//	@PostMapping("signup")
//	public int save(@RequestBody Credentials c) {
//		System.out.println("Signup Called");
//		cs.save(c);
//		System.out.println("Signup2 Called");
//		Customer customer = new Customer();
//		customer.setFirstname(c.getCustomer().getFirstname());
//		customer.setLastname(c.getCustomer().getLastname());
//		return cse.saveAndFlush(customer);
//	}
//}
