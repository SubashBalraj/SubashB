package com.abc.adminservice.service;



import com.abc.adminservice.model.TripBookingDetails;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "tripbooking-service")
public interface BookingServiceClient {

    @GetMapping("/booking/all")
    List<TripBookingDetails> getAllTripBookingDetails();

}