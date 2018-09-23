package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer>{

}
