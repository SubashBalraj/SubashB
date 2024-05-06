package com.abc.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.adminservice.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	

}
