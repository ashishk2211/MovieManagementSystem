package com.cg.moviemanagement.dao;

import java.util.List;

import com.cg.moviemanagement.entities.Booking;


public interface MovieDao {
	
	public boolean addBooking(Booking booking);
	public List<Booking> getBookingDetailsContact(String contact);
	public int countBookingInfo();
	public Booking getBookingDetails(String bookingId);
	public long getMaxBookingId(int showId);
}
