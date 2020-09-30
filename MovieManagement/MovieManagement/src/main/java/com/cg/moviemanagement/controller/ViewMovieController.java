package com.cg.moviemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.service.ViewMovieService;



@RestController
public class ViewMovieController {

	@Autowired
	private ViewMovieService service;
	
	
	@CrossOrigin
	@GetMapping("/viewmovies")
	public List<Movie> viewMovies() throws MovieNotFoundException {		
		return service.viewMovies();
	}
	
	
	@CrossOrigin
	@GetMapping("/viewnewmovies")
	public List<Movie> viewNewMovies() throws MovieNotFoundException {
		return service.viewNewMovies();
	}
}