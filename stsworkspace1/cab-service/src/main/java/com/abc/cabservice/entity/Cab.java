package com.abc.cabservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name="cab_tbl")
public class Cab {
	@Id
	@Column(length=5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cabId;
	@Column(length=50)
	private String carType;
	private float ratePerKm;
	
	 @Column(unique = true)
	private int driverId;

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(float ratePerKm) {
		this.ratePerKm = ratePerKm;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	
}
