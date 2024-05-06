package com.abc.tripbookingservice.service;

import com.abc.tripbookingservice.entity.TripBooking;

import java.util.List;

public interface TripBookingService {
    
	List<TripBooking> getAllBookings();
    
	TripBooking getBookingById(int bookingID);
    
	String createBooking(TripBooking booking);
    
	TripBooking updateBooking(int bookingID, TripBooking booking);
    
	String deleteBooking(int bookingID);
}
