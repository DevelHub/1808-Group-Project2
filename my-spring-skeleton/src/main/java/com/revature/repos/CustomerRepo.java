package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Customer;
import com.revature.projections.BasicCustomerProjection;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	List<BasicCustomerProjection> findAllProjectedBy();

}
