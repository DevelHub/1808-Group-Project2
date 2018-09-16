package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.CompanyReviews;

@Repository
public interface CompanyReviewsRepo extends JpaRepository<CompanyReviews, Integer>{

	List<CompanyReviews> findAll();
	
//	List<CompanyReviews> findByCompanyId(int companyId);
}
