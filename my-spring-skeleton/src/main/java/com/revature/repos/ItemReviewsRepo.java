package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.ItemReviews;

@Repository
public interface ItemReviewsRepo extends JpaRepository<ItemReviews, Integer>{

	
}
