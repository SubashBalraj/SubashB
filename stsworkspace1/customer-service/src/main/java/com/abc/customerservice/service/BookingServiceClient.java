package com.abc.customerservice.service;


import com.abc.customerservice.model.TripBookingDetails;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "tripbooking-service")
public interface BookingServiceClient {

    @PostMapping("/booking/save")
    String bookCab(@RequestBody TripBookingDetails tripBookingDetails);

    @DeleteMapping("/booking/{id}/delete")
    String cancelBooking(@PathVariable(name = "id") Integer bookingID);
    
}
