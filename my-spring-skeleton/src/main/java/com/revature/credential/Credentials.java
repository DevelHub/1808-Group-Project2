//package com.revature.credential;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.hibernate.validator.constraints.UniqueElements;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonProperty.Access;
//import com.revature.model.Customer;
//
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//@Entity
//@Table(name = "users_credentials")
//public class Credentials {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "user_id")
//	private int id;
//	private String username;
//	@JsonProperty(access = Access.WRITE_ONLY)
//	private String password;
//	@Column(name = "user_role")
//	private String role;
//	
//	@OneToOne
//	@JoinColumn(name = "user_id")
//	private Customer customer;
//
//	public Credentials() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Credentials(int id, @UniqueElements String username, String password, String role, Customer customer) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.role = role;
//		this.customer = customer;
//	}
//
//	/**
//	 * @return the id
//	 */
//	public int getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	/**
//	 * @return the username
//	 */
//	public String getUsername() {
//		return username;
//	}
//
//	/**
//	 * @param username the username to set
//	 */
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	/**
//	 * @return the password
//	 */
//	public String getPassword() {
//		return password;
//	}
//
//	/**
//	 * @param password the password to set
//	 */
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	/**
//	 * @return the role
//	 */
//	public String getRole() {
//		return role;
//	}
//
//	/**
//	 * @param role the role to set
//	 */
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	/**
//	 * @return the customer
//	 */
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	/**
//	 * @param customer the customer to set
//	 */
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	/* (non-Javadoc)
//	 * @see java.lang.Object#hashCode()
//	 */
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
//		result = prime * result + id;
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((role == null) ? 0 : role.hashCode());
//		result = prime * result + ((username == null) ? 0 : username.hashCode());
//		return result;
//	}
//
//	/* (non-Javadoc)
//	 * @see java.lang.Object#equals(java.lang.Object)
//	 */
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Credentials other = (Credentials) obj;
//		if (customer == null) {
//			if (other.customer != null)
//				return false;
//		} else if (!customer.equals(other.customer))
//			return false;
//		if (id != other.id)
//			return false;
//		if (password == null) {
//			if (other.password != null)
//				return false;
//		} else if (!password.equals(other.password))
//			return false;
//		if (role == null) {
//			if (other.role != null)
//				return false;
//		} else if (!role.equals(other.role))
//			return false;
//		if (username == null) {
//			if (other.username != null)
//				return false;
//		} else if (!username.equals(other.username))
//			return false;
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		return "Credentials [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
//				+ ", customer=" + customer + "]";
//	}
//}
