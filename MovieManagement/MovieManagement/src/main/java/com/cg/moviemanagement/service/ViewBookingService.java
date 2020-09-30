package com.cg.moviemanagement.service;
import java.util.List;

import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.exceptions.BookingException;


/************************************************************************
 * @author Ashish kumar
 * Description: This is the Service interface to show Booking Details functionality.
 * @version 1.0
 * @Created Date 17-APR-2020
 ************************************************************************/
public interface ViewBookingService {
	public List<Booking> getBookingDetails(String Contact)throws BookingException;
}
