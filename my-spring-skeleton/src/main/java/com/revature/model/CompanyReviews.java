package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "company_reviews")
public class CompanyReviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int id;
	@Column(name = "company_id")
	private int companyId;
	@Column(name = "customer_id")
	private int customerId;
    @DateTimeFormat(pattern = "dd.MM HH:MM")
	private Timestamp date;
	private int rating;
	private String review;
	public CompanyReviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyReviews(int id, int companyId, int customerId, Timestamp date, int rating, String review) {
		super();
		this.id = id;
		this.companyId = companyId;
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
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
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
		result = prime * result + companyId;
		result = prime * result + customerId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
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
		CompanyReviews other = (CompanyReviews) obj;
		if (companyId != other.companyId)
			return false;
		if (customerId != other.customerId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
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
		return "CompanyReviews [id=" + id + ", companyId=" + companyId + ", customerId=" + customerId + ", date=" + date
				+ ", rating=" + rating + ", review=" + review + "]";
	}
}
