package com.abc.customerservice.controller;

import com.abc.customerservice.entity.Customer;
import com.abc.customerservice.model.CabDetails;
import com.abc.customerservice.model.TripBookingDetails;
import com.abc.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int customerId, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") int customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cab/details")
    public ResponseEntity<List<CabDetails>> getCabDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCabDetails());
    }

    @PostMapping("/book/cab")
    public ResponseEntity<String> bookCab(@RequestBody TripBookingDetails tripBookingDetails) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.bookCab(tripBookingDetails));
    }


    @DeleteMapping("/cancel/booking")
    public ResponseEntity<String> deleteBooking(@RequestParam Integer bookingId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteBooking(bookingId));
    }
    

}