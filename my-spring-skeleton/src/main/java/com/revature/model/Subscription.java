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
@Table(name = "subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id")
	private int id;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "time_frame")
	private int timeFrame;
	@Column(name = "company_id")
	private int companyId;
	
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subscription(int id, int customerId, int timeFrame, int companyId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.timeFrame = timeFrame;
		this.companyId = companyId;
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
	public int getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(int timeFrame) {
		this.timeFrame = timeFrame;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result + customerId;
		result = prime * result + id;
		result = prime * result + timeFrame;
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
		Subscription other = (Subscription) obj;
		if (companyId != other.companyId)
			return false;
		if (customerId != other.customerId)
			return false;
		if (id != other.id)
			return false;
		if (timeFrame != other.timeFrame)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", customerId=" + customerId + ", timeFrame=" + timeFrame + ", companyId="
				+ companyId + "]";
	}
	
}
