/*************************************************************************************************************************
*          @author          Arushi Bhardwaj,Ashish Kumar
*          Description      It is a service class that provides the services for  adding and cancelling a movie ticket 
*   
*         Created Date    19-SEPT-2020
***************************************************************************************************************************/




package com.cg.moviemanagement.service;

import com.cg.moviemanagement.dto.BookingForm;
import com.cg.moviemanagement.exceptions.BookingException;

public interface MovieBookingService {
	
	public String addBooking(BookingForm bookingForm)throws BookingException;
	public boolean cancelBooking(String bookingId);
	

}
