package com.abc.tripbookingservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abc.tripbookingservice.entity.TripBooking;
import com.abc.tripbookingservice.exception.ResourceNotFoundException;
import com.abc.tripbookingservice.repository.TripBookingRepository;
import com.abc.tripbookingservice.service.TripBookingServiceImpl;

public class TripBookingServiceTest {

    @Mock
    private TripBookingRepository tripBookingRepository;

    @InjectMocks
    private TripBookingServiceImpl tripBookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBookings() {
        
        List<TripBooking> mockBookings = List.of(
                new TripBooking(), new TripBooking(), new TripBooking());
        when(tripBookingRepository.findAll()).thenReturn(mockBookings);

        
        List<TripBooking> result = tripBookingService.getAllBookings();

       
        assertEquals(3, result.size());
    }

    @Test
    void testGetBookingById() {
       
        int bookingID = 1;
        TripBooking mockBooking = new TripBooking();
        mockBooking.setBookingID(bookingID);
        when(tripBookingRepository.findById(bookingID)).thenReturn(Optional.of(mockBooking));

        
        TripBooking result = tripBookingService.getBookingById(bookingID);

        // Verify
        assertEquals(bookingID, result.getBookingID());
    }

    @Test
    void testGetBookingById_NotFound() {
        
        int bookingID = 1;
        when(tripBookingRepository.findById(bookingID)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> tripBookingService.getBookingById(bookingID));
    }

    @Test
    void testCreateBooking() {
        
        TripBooking booking = new TripBooking();

       
        String result = tripBookingService.createBooking(booking);

        
        assertEquals("Booking confirmed", result);
        verify(tripBookingRepository).save(booking);
    }

    @Test
    void testUpdateBooking() {
       
        int bookingID = 1;
        TripBooking existingBooking = new TripBooking();
        existingBooking.setBookingID(bookingID);
        when(tripBookingRepository.existsById(bookingID)).thenReturn(true);
        when(tripBookingRepository.save(existingBooking)).thenReturn(existingBooking);

        TripBooking updatedBooking = tripBookingService.updateBooking(bookingID, existingBooking);

        assertEquals(bookingID, updatedBooking.getBookingID());
        verify(tripBookingRepository).save(existingBooking);
    }

    @Test
    void testUpdateBooking_NotFound() {
     
        int bookingID = 1;
        TripBooking nonExistingBooking = new TripBooking();
        when(tripBookingRepository.existsById(bookingID)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> tripBookingService.updateBooking(bookingID, nonExistingBooking));
    }

    @Test
    void testDeleteBooking() {
       
        int bookingID = 1;
        when(tripBookingRepository.existsById(bookingID)).thenReturn(true);

        String result = tripBookingService.deleteBooking(bookingID);

        assertEquals("Booking cancelled successfully", result);
        verify(tripBookingRepository).deleteById(bookingID);
    }

    @Test
    void testDeleteBooking_NotFound() {
   
        int bookingID = 1;
        when(tripBookingRepository.existsById(bookingID)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> tripBookingService.deleteBooking(bookingID));
    }

}
