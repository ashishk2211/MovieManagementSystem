package com.cg.moviemanagement.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;


/*************************************************************************************************************************
 * @author Ashish kumar
 * Description : It is a dao implementation class, which has functionality of all of movie management functions and does the
 * 				transactions with entity classes. using entity manager.
 *  Created Date 21-SEPT2020
 *************************************************************************************************************************/
@Repository
public class MovieDaoImpl implements MovieDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean addMovie(Movie movie) {
		em.persist(movie);
		return true;
	}

	@Override
	public boolean editMovie(Movie movie) {
		em.merge(movie);
		return true;
	}

	@Override
	public Movie viewMovie(int movieId) {
		
		return em.find(Movie.class, movieId);
	}
	
	@Override
	public List<Movie> viewActiveMovies() {
		String jpql = "from Movie m where m.active=1";
		TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
		
		return query.getResultList();
	}
	@Override
	public List<Show> getShows(int movieId) {
		String jpql = "from Show s inner join fetch s.movie m where m.movieId=:mid ";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		
		query.setParameter("mid", movieId);
		//query.setParameter("dt", LocalDate.now());
		return query.getResultList();
	}

	@Override
	public boolean editShow(Show show) {
		em.merge(show);
		return true;
	}

	@Override
	public boolean addBooking(Booking booking) {
		em.persist(booking);
		return true;
	}

	/*********************************************************************************************************************
	 * Method: getBookingDetails
	 * Description: To show the details of ticket booked by a certain using Contact Number as parameter.
	 * @param contact: contact used in the booking process
	 * Created By - Ashish kumar
	 * Created Date - 21-SEPT-2020
	 *********************************************************************************************************************/
	@Override
	public List<Booking> getBookingDetailsContact(String contact) {
		String jpql = "from Booking b inner join fetch b.show s inner join fetch s.movie m where b.contact=:phone";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		
		query.setParameter("phone", contact);
		return query.getResultList();
	}

	@Override
	public Booking getBookingDetails(String bookingId) {
		String jpql = "from Booking b inner join fetch b.show s inner join fetch s.movie m where b.bookingId=:bid";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("bid", bookingId);
		return query.getSingleResult();
	}
	
	@Override
	public int countBookingInfo() {
		String jpql = "select count(bookingId) from Booking";
		TypedQuery<Integer> query = em.createQuery(jpql,Integer.class);
		return query.getSingleResult();
		
	}

	
	@Override
	public List<Movie> getMovies(String searchStr) {
		String jpql = "from Movie m where m.movieName like :str or m.director like :str or m.language like :str or m.genre like :str";
		TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
		
		query.setParameter("str", searchStr);
		return query.getResultList();
	}

	@Override
	public Show getShow(int showId) {
		return em.find(Show.class, showId);
	}

	
	@Override
	public long getMaxBookingId(int showId) {
		String jpql = "select count(b.bookingId) from Booking b join b.show s where s.showId=:showid";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("showid", showId);
		return query.getSingleResult();
	}

	
	
	@Override
	public List<Show> getShows(String screenName) {
		String jpql = "from Show s inner join fetch s.movie m where s.screenName=:screenname and s.showDate >= :dt";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		
		query.setParameter("screenname", screenName);
		query.setParameter("dt", LocalDate.now());
		return query.getResultList();
	}

	@Override
	public List<Show> getShows() {
		String jpql = "from Show s inner join fetch s.movie m where  s.showDate >= :dt";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		query.setParameter("dt", LocalDate.now());
		return query.getResultList();
		
	}

	@Override
	public boolean removeBooking(Booking booking) {
		em.remove(booking);
		return true;
	}

}
