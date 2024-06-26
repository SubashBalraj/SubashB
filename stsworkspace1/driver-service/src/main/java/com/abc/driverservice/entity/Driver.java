package com.abc.driverservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "driver_tbl")
public class Driver {
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@EqualsAndHashCode.Include
	private int userId;

	@NotNull(message = "Cannot be Null")
	private String username;

	@Size(min = 4, max = 20, message = "password length should be between 4 to 20")
	@NotNull(message = "Cannot be Null")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addrId")
	private Address address;

	@Size(min = 10, message = "mobile no should be of 10 digits")
	private String mobile;

	@Email
	@NotNull(message = "Cannot be Null")
	private String email;

	@Size(min = 1, message = "License number cannot be empty")
	private String licenseNo;
	@Min(value = 1, message = "id should be more than 1")
	private float rating;
	private boolean available;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

}