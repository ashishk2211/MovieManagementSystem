package com.cg.moviemanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.util.MovieConstants;
/************************************************************************
 * @author Ashish kumar
 * Description: This is the Service class to show Booking Details by 
 * entering Contact Information.
 * @Created Date 22-SEPT-2020
 ************************************************************************/
@Transactional
@Service
public class ViewBookingServiceImpl implements ViewBookingService {

	@Autowired
	private MovieDao dao;
	
	/*********************************************************************************************
	 * Method: getBookingDetails
	 * Description: To Show all the details of booking using the contact number.
	 * @param Contact   		 - Contact number entered by user to search for booking details.
	 * @returns bookingList		 - true if Details found, otherwise throws NotFoundException.
	 * @throws NotFoundException - It is raised due to wrong contact number given by the user.
	 * Created By				 - Ashish kumar
	 * Created Date				 - 18-APR-2020 	
	 ********************************************************************************************/
	@Override
	public List<Booking> getBookingDetails(String Contact) throws BookingException {
		List<Booking> bookingLst = dao.getBookingDetailsContact(Contact); 
		if(bookingLst.isEmpty())
			throw new BookingException(MovieConstants.BOOKING_NOT_AVAILABLE);
		bookingLst.sort((b1,b2)->b2.getBookingDate().compareTo(b1.getBookingDate()));
		return bookingLst;
	}

}
