package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Subscription;
import com.revature.projections.BasicSubscriptionProjection;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {
	
	List<BasicSubscriptionProjection> findByCompanyId(int id);
}
