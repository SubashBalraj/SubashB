package com.abc.customerservice.service;

import com.abc.customerservice.entity.Customer;
import com.abc.customerservice.model.CabDetails;
import com.abc.customerservice.model.TripBookingDetails;

import java.util.List;

public interface CustomerService {
	
    List<Customer> getAllCustomers();
    
    Customer getCustomerById(int customerId);
    
    Customer createCustomer(Customer customer);
    
    Customer updateCustomer(int customerId, Customer customer);
    
    void deleteCustomer(int customerId);

    List<CabDetails> getCabDetails();

    String bookCab(TripBookingDetails tripBookingDetails);

    String deleteBooking(Integer bookingId);
    
    
}

