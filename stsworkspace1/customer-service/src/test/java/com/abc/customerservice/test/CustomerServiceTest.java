package com.abc.customerservice.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abc.customerservice.entity.Customer;
import com.abc.customerservice.model.CabDetails;
import com.abc.customerservice.model.TripBookingDetails;
import com.abc.customerservice.repository.CustomerRepository;
import com.abc.customerservice.service.CustomerServiceImpl;
import com.abc.customerservice.service.CabServiceClient;
import com.abc.customerservice.service.BookingServiceClient;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CabServiceClient cabServiceClient;

    @Mock
    private BookingServiceClient bookingServiceClient;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> retrievedCustomers = customerService.getAllCustomers();

        assertNotNull(retrievedCustomers);
        assertEquals(2, retrievedCustomers.size());
    }

    @Test
    public void testGetCustomerById() {
        int customerId = 1;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setName("Ram");

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Customer retrievedCustomer = customerService.getCustomerById(customerId);

        assertNotNull(retrievedCustomer);
        assertEquals(customerId, retrievedCustomer.getCustomerId());
        assertEquals("Ram", retrievedCustomer.getName());
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("Ram");

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        assertNotNull(createdCustomer);
        assertEquals("Ram", createdCustomer.getName());
    }

    @Test
    public void testUpdateCustomer() {
        int customerId = 1;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setName("Ram");

        when(customerRepository.existsById(customerId)).thenReturn(true);
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer updatedCustomer = customerService.updateCustomer(customerId, customer);

        assertNotNull(updatedCustomer);
        assertEquals(customerId, updatedCustomer.getCustomerId());
        assertEquals("Ram", updatedCustomer.getName());
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 1;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);

        when(customerRepository.existsById(customerId)).thenReturn(true);

        assertDoesNotThrow(() -> customerService.deleteCustomer(customerId));
    }

    @Test
    public void testBookCab() {
        TripBookingDetails tripBookingDetails = new TripBookingDetails();
        tripBookingDetails.setCustomerID(1);

        when(bookingServiceClient.bookCab(tripBookingDetails)).thenReturn("Booking successful");

        String result = customerService.bookCab(tripBookingDetails);

        assertEquals("Booking successful", result);
    }

    
    @Test
    public void testDeleteBooking() {
        Integer bookingId = 1;

        when(bookingServiceClient.cancelBooking(bookingId)).thenReturn("Booking cancelled");

        String result = customerService.deleteBooking(bookingId);

        assertEquals("Booking cancelled", result);
    }
}
