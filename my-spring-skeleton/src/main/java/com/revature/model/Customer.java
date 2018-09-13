//package com.revature.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//@Entity
//@Table(name = "customer")
//public class Customer {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "customer_id")
//	private int id;
//	private int userId;
//	private int addressId;
//	private float cardNumber;
//	private String gender;
//	private String ethnicity;
//	private String dateOfBirth;
//	private String age;
//	public Customer() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Customer(int id, int userId, int addressId, float cardNumber, String gender, String ethnicity,
//			String dateOfBirth, String age, String firstname, String lastname) {
//		super();
//		this.id = id;
//		this.userId = userId;
//		this.addressId = addressId;
//		this.cardNumber = cardNumber;
//		this.gender = gender;
//		this.ethnicity = ethnicity;
//		this.dateOfBirth = dateOfBirth;
//		this.age = age;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public int getAddressId() {
//		return addressId;
//	}
//	public void setAddressId(int addressId) {
//		this.addressId = addressId;
//	}
//	public float getCardNumber() {
//		return cardNumber;
//	}
//	public void setCardNumber(float cardNumber) {
//		this.cardNumber = cardNumber;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public String getEthnicity() {
//		return ethnicity;
//	}
//	public void setEthnicity(String ethnicity) {
//		this.ethnicity = ethnicity;
//	}
//	public String getDateOfBirth() {
//		return dateOfBirth;
//	}
//	public void setDateOfBirth(String dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//	public String getAge() {
//		return age;
//	}
//	public void setAge(String age) {
//		this.age = age;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + addressId;
//		result = prime * result + ((age == null) ? 0 : age.hashCode());
//		result = prime * result + Float.floatToIntBits(cardNumber);
//		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
//		result = prime * result + ((ethnicity == null) ? 0 : ethnicity.hashCode());
//		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
//		result = prime * result + id;
//		result = prime * result + userId;
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Customer other = (Customer) obj;
//		if (addressId != other.addressId)
//			return false;
//		if (age == null) {
//			if (other.age != null)
//				return false;
//		} else if (!age.equals(other.age))
//			return false;
//		if (Float.floatToIntBits(cardNumber) != Float.floatToIntBits(other.cardNumber))
//			return false;
//		if (dateOfBirth == null) {
//			if (other.dateOfBirth != null)
//				return false;
//		} else if (!dateOfBirth.equals(other.dateOfBirth))
//			return false;
//		if (ethnicity == null) {
//			if (other.ethnicity != null)
//				return false;
//		} else if (!ethnicity.equals(other.ethnicity))
//			return false;
//		if (gender == null) {
//			if (other.gender != null)
//				return false;
//		} else if (!gender.equals(other.gender))
//			return false;
//		if (id != other.id)
//			return false;
//		if (userId != other.userId)
//			return false;
//		return true;
//	}
//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", userId=" + userId + ", addressId=" + addressId + ", cardNumber=" + cardNumber
//				+ ", gender=" + gender + ", ethnicity=" + ethnicity + ", dateOfBirth=" + dateOfBirth + ", age=" + age
//				+ "]";
//	}
//	
//}
