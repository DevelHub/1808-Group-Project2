package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Item_Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_type_id;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	public Item_Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item_Type(int item_type_id, String type, Item item) {
		super();
		this.item_type_id = item_type_id;
		this.type = type;
		this.item = item;
	}

	public int getItem_type_id() {
		return item_type_id;
	}

	public void setItem_type_id(int item_type_id) {
		this.item_type_id = item_type_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + item_type_id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Item_Type other = (Item_Type) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (item_type_id != other.item_type_id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item_Type [item_type_id=" + item_type_id + ", type=" + type + ", item=" + item + "]";
	}

	

	
	

}
