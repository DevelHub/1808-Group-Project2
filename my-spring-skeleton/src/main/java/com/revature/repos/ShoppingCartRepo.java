package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.ShoppingCart;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer>{

	List<ShoppingCart> findByCustomerId(int customerId);
}
