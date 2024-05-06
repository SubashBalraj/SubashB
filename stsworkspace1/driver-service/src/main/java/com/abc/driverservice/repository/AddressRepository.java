package com.abc.driverservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.driverservice.entity.Address;



public interface AddressRepository extends JpaRepository<Address, Integer> {

}
