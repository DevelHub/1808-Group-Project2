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
@Table(name = "item_reviews")
public class ItemReviews {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int id;
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "customer_id")
	private int customerId;
	private int date;
	private int rating;
	private String review;
	public ItemReviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemReviews(int id, int itemId, int customerId, int date, int rating, String review) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.customerId = customerId;
		this.date = date;
		this.rating = rating;
		this.review = review;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + date;
		result = prime * result + id;
		result = prime * result + itemId;
		result = prime * result + rating;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
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
		ItemReviews other = (ItemReviews) obj;
		if (customerId != other.customerId)
			return false;
		if (date != other.date)
			return false;
		if (id != other.id)
			return false;
		if (itemId != other.itemId)
			return false;
		if (rating != other.rating)
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ItemReviews [id=" + id + ", itemId=" + itemId + ", customerId=" + customerId + ", date=" + date
				+ ", rating=" + rating + ", review=" + review + "]";
	}
	
}
