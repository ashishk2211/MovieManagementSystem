package com.cg.moviemanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.exceptions.ShowException;
import com.cg.moviemanagement.util.MovieConstants;


@Transactional
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private MovieDao dao;

	@Override
	public List<Movie> getMovies(String searchStr) throws MovieNotFoundException {
		List<Movie> movieLst = dao.getMovies(searchStr);
		if(movieLst.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		List<Movie> lst = movieLst.stream().filter(m->m.getActive()==MovieConstants.ACTIVE).sorted((m1,m2)->m1.getMovieName().compareTo(m2.getMovieName())).collect(Collectors.toList());
		return lst;
	}

	
	@Override
	public List<Show> getShows(String screenName) throws ShowException {
		List<Show> showList = dao.getShows(screenName);
		
		if(showList.isEmpty())
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		showList.sort((s1,s2)->s1.getScreenName().compareTo(s2.getScreenName()));
		return showList;
	}

	/*********************************************************************************************************************
	 * Method: getShows 
	 * Description: To give a list of shows by taking searchDt and movie id as input.
	 * @param searchDt: date in which shows are to be searched.
	 * @param movieId: movie id for which shows are to be searched.
	 *              Created By - Ashish kumar 
	 *              Created Date - 23-SEPT-2020
	 * @throws ShowException - When a show is search for a screen which does not exist in database, exception is thrown.
	 *********************************************************************************************************************/
	@Override
	public List<Show> getShows(LocalDate searchDt, int movieId) throws ShowException {
		List<Show> showList = dao.getShows(movieId).stream().filter(s->s.getShowDate().equals(searchDt)).collect(Collectors.toList());
		if(showList.isEmpty())
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		return showList;
	}

	

	@Override
	public List<Show> getShows(String screenName, LocalDate searchDt, int movieId) throws ShowException {
		List<Show> showList = dao.getShows(movieId).stream().filter(s->s.getShowDate().equals(searchDt) && s.getScreenName().contentEquals(screenName)).collect(Collectors.toList());
		if(showList.isEmpty())
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		return showList;
	}

	

	@Override
	public List<Show> getShows(String screenName, LocalDate searchDt) throws ShowException {
		List<Show> showList = dao.getShows().stream().filter(s->s.getShowDate().equals(searchDt) && s.getScreenName().contentEquals(screenName)).collect(Collectors.toList());
		if(showList.isEmpty())
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		return showList;
	}
}
