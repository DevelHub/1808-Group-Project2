package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
//	@Column(name = "customer_id")
//	private int customerId;
	@Column(name = "time_frame")
	private int timeFrame;
//	@Column(name = "company_id")
//	private int companyId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer subscriber;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscription(int id, int timeFrame, Customer subscriber, Company company) {
		super();
		this.id = id;
		this.timeFrame = timeFrame;
		this.subscriber = subscriber;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(int timeFrame) {
		this.timeFrame = timeFrame;
	}

	public Customer getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Customer subscriber) {
		this.subscriber = subscriber;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + id;
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
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
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (id != other.id)
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		if (timeFrame != other.timeFrame)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", timeFrame=" + timeFrame + ", subscriber=" + subscriber + ", company="
				+ company + "]";
	}
}
