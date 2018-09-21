package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.CompanyReviews;
import com.revature.repos.CompanyReviewsRepo;

@Service
public class CompanyReviewsService {

	@Autowired
	private CompanyReviewsRepo crs;
	
	public int save(CompanyReviews cr) {
		return crs.save(cr).getId();
	}
	
	public List<CompanyReviews> findAll() {
		return crs.findAll();
	}
}
