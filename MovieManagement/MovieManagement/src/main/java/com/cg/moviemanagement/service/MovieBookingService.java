package com.cg.moviemanagement.service;

import com.cg.moviemanagement.dto.BookingForm;
import com.cg.moviemanagement.exceptions.BookingException;

public interface MovieBookingService {
	

	public String addBooking(BookingForm bookingForm)throws BookingException;
	public boolean cancelBooking(String bookingId) throws BookingException;

}
