package com.abc.customerservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="customer_tbl")
public class Customer {

    @Id
    @Column(length=5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int customerId;
    
    @Column(length=50)
    @NotBlank(message = "Name is required")
    private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	

   
}

