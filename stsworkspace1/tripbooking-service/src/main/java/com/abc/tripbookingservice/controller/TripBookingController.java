package com.abc.tripbookingservice.controller;

import com.abc.tripbookingservice.entity.TripBooking;
import com.abc.tripbookingservice.service.TripBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class TripBookingController {

    @Autowired
    private TripBookingService tripBookingService;

    @GetMapping("/all")
    public List<TripBooking> getAllBookings() {
        return tripBookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripBooking> getBookingById(@PathVariable("id") int bookingID) {
        TripBooking booking = tripBookingService.getBookingById(bookingID);
        return ResponseEntity.ok(booking);
    }

    @PostMapping("/save")
    public ResponseEntity<String> createBooking(@RequestBody TripBooking booking) {
        String createdBooking = tripBookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @PutMapping("/{id}/save")
    public ResponseEntity<TripBooking> updateBooking(@PathVariable("id") int bookingID, @RequestBody TripBooking booking) {
        TripBooking updatedBooking = tripBookingService.updateBooking(bookingID, booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") int bookingID) {
        return ResponseEntity.status(HttpStatus.OK).body(tripBookingService.deleteBooking(bookingID));
    }
}
