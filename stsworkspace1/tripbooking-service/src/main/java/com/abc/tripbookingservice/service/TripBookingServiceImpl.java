package com.abc.tripbookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.tripbookingservice.entity.TripBooking;
import com.abc.tripbookingservice.exception.ResourceNotFoundException;
import com.abc.tripbookingservice.repository.TripBookingRepository;

@Service
public class TripBookingServiceImpl implements TripBookingService {

    @Autowired
    private TripBookingRepository tripBookingRepository;

    @Override
    public List<TripBooking> getAllBookings() {
        return tripBookingRepository.findAll();
    }

    @Override
    public TripBooking getBookingById(int bookingID) {
        return tripBookingRepository.findById(bookingID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip booking not found with ID: " + bookingID));
    }

    @Override
    public String createBooking(TripBooking booking) {
        try{
            tripBookingRepository.save(booking);
            return "Booking confirmed";
        } catch (Exception e){
            if(e.getMessage()!=null){
                return e.getMessage();
            }
            return "Error while booking";
        }
    }

    @Override
    public TripBooking updateBooking(int bookingID, TripBooking booking) {
        if (!tripBookingRepository.existsById(bookingID)) {
            throw new ResourceNotFoundException("Trip booking not found with ID: " + bookingID);
        }
        booking.setBookingID(bookingID);
        return tripBookingRepository.save(booking);
    }

    @Override
    public String deleteBooking(int bookingID) {
        if (!tripBookingRepository.existsById(bookingID)) {
            throw new ResourceNotFoundException("Trip booking not found with ID: " + bookingID);
        }
        tripBookingRepository.deleteById(bookingID);
        return "Booking cancelled successfully";
    }
}
