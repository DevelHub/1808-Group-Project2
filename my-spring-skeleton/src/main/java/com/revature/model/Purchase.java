package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private int id;
//	@Column(name = "item_id")
//	private int itemId;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "purchase_date")
    @DateTimeFormat(pattern = "dd.MM HH:MM")
	private Timestamp purchaseDate;
	@Column(name = "delivery_date")
    @DateTimeFormat(pattern = "dd.MM HH:MM")
	private Timestamp deliveryDate;
	
	@ManyToOne
    @JoinColumn(name = "item_id")
	private Item item;

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(int id, int customerId, Timestamp purchaseDate, Timestamp deliveryDate, Item item) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.purchaseDate = purchaseDate;
		this.deliveryDate = deliveryDate;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Item getitem() {
		return item;
	}

	public void setitem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
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
		Purchase other = (Purchase) obj;
		if (customerId != other.customerId)
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", customerId=" + customerId + ", purchaseDate=" + purchaseDate
				+ ", deliveryDate=" + deliveryDate + ", item=" + item + "]";
	}
}
