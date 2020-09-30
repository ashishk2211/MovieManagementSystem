package com.cg.moviemanagement.service;
import java.time.LocalDate;
import java.util.List;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.exceptions.ShowException;

/*************************************************************************************************************************
 * @author Ashish kumar, Arushi bharadwaj 
 * Description It is a service interface which is implemented by the class having business logic for search functionality,
 * 			   the reference of this interface is to be given to whichever class wanted to use the search functionality.
 *         Version 1.0 
 *         Created Date 17-APR-2020
 *************************************************************************************************************************/
public interface SearchService {

	public List<Movie> getMovies(String searchStr)throws MovieNotFoundException;
	public List<Show> getShows(String screenName)throws ShowException;
	public List<Show> getShows(LocalDate searchDt, int movieId)throws ShowException;
	public List<Show> getShows(String screenName, LocalDate searchDt, int movieId)throws ShowException;
	public List<Show> getShows(String screenName, LocalDate searchDt)throws ShowException;
}