package com.cg.moviemanagement.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.exceptions.BookingException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewBookingTest {
	
	@Mock
	private MovieDao dao;
	
	@Autowired
	private ViewBookingServiceImpl service;
	
	@Test
	public void bookingExist() throws BookingException {
		
		List<Booking> bookingInformation=service.getBookingDetails("8283037007");
		assertFalse(bookingInformation.isEmpty());
		
	}
//	@Test
//	public void bookingNotExist() throws BookingException {
//		
//		List<Booking> bookingInformation=service.getBookingDetails("8283039007");
//		assertTrue("Booking Not Available ");
//		
//	}
	
	

}
