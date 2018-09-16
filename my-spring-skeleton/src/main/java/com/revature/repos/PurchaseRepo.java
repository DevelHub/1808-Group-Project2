package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Integer>{

	List<Purchase> findByCustomerId(int customerId);
}
