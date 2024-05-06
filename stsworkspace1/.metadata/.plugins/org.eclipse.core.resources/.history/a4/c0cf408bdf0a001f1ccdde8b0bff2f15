package com.abc.adminservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.abc.adminservice.model.CustomerDetails;

@FeignClient(name="customer-service")
public interface CustomerServiceClient {
	
	 @GetMapping("/customer/all")
	    List<CustomerDetails> getAllCustomerDetails();

}
