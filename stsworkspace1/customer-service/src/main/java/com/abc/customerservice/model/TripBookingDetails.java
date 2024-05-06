package com.abc.customerservice.model;

import java.time.LocalDateTime;

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
	    
	    
		public int getBookingID() {
			return bookingID;
		}
		public void setBookingID(int bookingID) {
			this.bookingID = bookingID;
		}
		public int getCabId() {
			return cabId;
		}
		public void setCabId(int cabId) {
			this.cabId = cabId;
		}
		public int getCustomerID() {
			return customerID;
		}
		public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}
		public String getFromLocation() {
			return fromLocation;
		}
		public void setFromLocation(String fromLocation) {
			this.fromLocation = fromLocation;
		}
		public String getToLocation() {
			return toLocation;
		}
		public void setToLocation(String toLocation) {
			this.toLocation = toLocation;
		}
		public LocalDateTime getFromDateTime() {
			return fromDateTime;
		}
		public void setFromDateTime(LocalDateTime fromDateTime) {
			this.fromDateTime = fromDateTime;
		}
		public LocalDateTime getToDateTime() {
			return toDateTime;
		}
		public void setToDateTime(LocalDateTime toDateTime) {
			this.toDateTime = toDateTime;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public double getDistanceInKm() {
			return distanceInKm;
		}
		public void setDistanceInKm(double distanceInKm) {
			this.distanceInKm = distanceInKm;
		}
		public double getBill() {
			return bill;
		}
		public void setBill(double bill) {
			this.bill = bill;
		}

}
