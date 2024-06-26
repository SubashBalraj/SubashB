package com.abc.driverservice.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TripBookingDetails {
	
private int bookingID;
	
	
    private int cabId;
    private int customerID;
    private String fromLocation;
    private String toLocation;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private boolean status;
    private double distanceInKm;
    private double bill;

}
