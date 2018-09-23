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
@Table(name = "subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id")
	private int id;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "time_frame")
    @DateTimeFormat(pattern = "dd.MM HH:MM")
	private Timestamp timeFrame;
	@Column(name = "company_id")
	private int companyId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", insertable = false, updatable = false)
	private Customer subscriber;
	
	@ManyToOne
	@JoinColumn(name = "company_id", insertable = false, updatable = false)
	private Company company;

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscription(int id, int customerId, Timestamp timeFrame, int companyId, Customer subscriber,
			Company company) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.timeFrame = timeFrame;
		this.companyId = companyId;
		this.subscriber = subscriber;
		this.company = company;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the timeFrame
	 */
	public Timestamp getTimeFrame() {
		return timeFrame;
	}

	/**
	 * @param timeFrame the timeFrame to set
	 */
	public void setTimeFrame(Timestamp timeFrame) {
		this.timeFrame = timeFrame;
	}

	/**
	 * @return the companyId
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the subscriber
	 */
	public Customer getSubscriber() {
		return subscriber;
	}

	/**
	 * @param subscriber the subscriber to set
	 */
	public void setSubscriber(Customer subscriber) {
		this.subscriber = subscriber;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + companyId;
		result = prime * result + customerId;
		result = prime * result + id;
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
		result = prime * result + ((timeFrame == null) ? 0 : timeFrame.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (companyId != other.companyId)
			return false;
		if (customerId != other.customerId)
			return false;
		if (id != other.id)
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		if (timeFrame == null) {
			if (other.timeFrame != null)
				return false;
		} else if (!timeFrame.equals(other.timeFrame))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", customerId=" + customerId + ", timeFrame=" + timeFrame + ", companyId="
				+ companyId + ", subscriber=" + subscriber + ", company=" + company + "]";
	}
}
