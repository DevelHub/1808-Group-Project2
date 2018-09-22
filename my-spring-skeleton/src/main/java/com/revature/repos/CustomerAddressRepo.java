package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.CustomerAddress;

@Repository
public interface CustomerAddressRepo extends JpaRepository<CustomerAddress, Integer>{

	
}
