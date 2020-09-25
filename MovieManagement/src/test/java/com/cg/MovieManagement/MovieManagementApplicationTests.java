package com.cg.MovieManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.moviemanagement.dto.BookingForm;
import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.service.MovieBookingServiceImpl;

@SpringBootTest
class MovieManagementApplicationTests {

	@Test
	void checkTickets(){
		MovieBookingServiceImpl object= new MovieBookingServiceImpl();
		BookingForm bookingForm=new BookingForm(1011,4,"Arushi Bhardwaj","8728925856");
		assertThrows(BookingException.class,()->{object.addBooking(bookingForm);});
		
	}
    @Test
    void addBookingTest()throws BookingException{
    	MovieBookingServiceImpl object=new MovieBookingServiceImpl();
    	BookingForm bookingForm=new BookingForm(1011,4,"Arushi Bhardwaj","8728925856");
    	String id=object.addBooking(bookingForm);
    	assertEquals(String.class,id.getClass());
    }
}
