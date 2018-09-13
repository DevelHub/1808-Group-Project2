//package com.revature.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.revature.model.Customer;
//import com.revature.projections.BasicCustomerProjection;
//import com.revature.repos.CustomerRepo;
//
//@Service
//public class CustomerService {
//
//	@Autowired
//	private CustomerRepo cr;
//
////	public List<BasicUserProjection> findAll() {
////		return ur.findById(id);
////	}
//
////	@Transactional(propagation = Propagation.MANDATORY)
////	public AppUser findOne(int id) {
////		AppUser u = ur.getOne(id);
////		return u;
////	}
//
////	public BasicUserProjection login(String username, String password) {
////		return ur.findByUsernameAndPassword(username, password);
////	}
//
//	public List<Customer> findByUsernameAndPassword(String username, String password) {
//		return cr.findByUsernameAndPassword(username, password);
//	}
//	
//	public BasicCustomerProjection findPasswordByUsername(String username) {
//		return cr.findPasswordByUsername(username);
//	}
//}
