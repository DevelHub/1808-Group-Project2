package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "wish_list")
public class Wish_List {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "list_id")
	private int list_id;
	@Column(name = "item_id")
	private int item_id;
	@Column(name = "customer_id")
	private int customer_id;
	
	public Wish_List() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wish_List(int list_id, int item_id, int customer_id) {
		super();
		this.list_id = list_id;
		this.item_id = item_id;
		this.customer_id = customer_id;
	}

	public int getList_id() {
		return list_id;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer_id;
		result = prime * result + item_id;
		result = prime * result + list_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wish_List other = (Wish_List) obj;
		if (customer_id != other.customer_id)
			return false;
		if (item_id != other.item_id)
			return false;
		if (list_id != other.list_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wish_List [list_id=" + list_id + ", item_id=" + item_id + ", customer_id=" + customer_id + "]";
	}
	
	
	
	
	
	

}
