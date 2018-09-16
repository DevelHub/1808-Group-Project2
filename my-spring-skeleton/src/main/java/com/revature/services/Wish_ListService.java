package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Wish_List;
import com.revature.repos.Wish_ListRepo;

@Service
public class Wish_ListService {
	@Autowired
	Wish_ListRepo wr;
	
	public int save(Wish_List w) {
		return wr.save(w).getList_id();
	}

}
