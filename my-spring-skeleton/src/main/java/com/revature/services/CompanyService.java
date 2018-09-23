package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Company;
import com.revature.repos.CompanyRepo;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepo cr;
	
	public List<Company> findAll() {
		return cr.findAll();
	}
	
}
