package com.cg.moviemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.util.MovieConstants;

@Transactional
@Service
public class ViewMovieServiceImpl implements ViewMovieService{

	@Autowired
	private MovieDao dao;
	
	
	@Override
	public List<Movie> viewMovies() throws MovieNotFoundException {
		List<Movie> movielst = dao.viewActiveMovies();
		if(movielst.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		movielst.sort((m1,m2)->m1.getMovieName().compareTo(m2.getMovieName()));
		return movielst;
	}

	@Override
	public List<Movie> viewNewMovies() throws MovieNotFoundException {
		List<Movie> movielst = dao.viewActiveMovies();
		if(movielst.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		List<Movie> newMovies = new ArrayList<>();
		newMovies.addAll(getMovies(movielst, MovieConstants.ENGLISH));
		newMovies.addAll(getMovies(movielst, MovieConstants.HINDI));
		newMovies.addAll(getMovies(movielst, MovieConstants.TELUGU));
		return newMovies;
	}
	
	public List<Movie> getMovies(List<Movie> movielst, String language){
		return movielst.stream().filter(m->m.getLanguage().equalsIgnoreCase(language)).sorted((m1,m2)->m2.getReleaseDt().compareTo(m1.getReleaseDt()))
				.limit(2).collect(Collectors.toList());
	}

}