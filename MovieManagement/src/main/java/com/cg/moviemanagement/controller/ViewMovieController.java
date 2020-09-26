package com.cg.moviemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.service.ViewMovieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ViewMovieController {

	@Autowired
	private ViewMovieService service;
	@Autowired
	private MovieDao dao;
	
	/*********************************************************************************************************************************
	 * Method: viewmovies
     *Description: To give a list of movies in database. 
	 * @throws MovieNotFoundException 
	 * @returns List<Movie>       - all movies which are currently active.
                *Created By                              - prameela
                *Created Date                            - 26-SEP-2020                           	 
	 **********************************************************************************************************************************/
	
	@GetMapping("/viewmovies")
	public List<Movie> viewMovies() throws MovieNotFoundException {		
		return service.viewMovies();
	}
	
	/*********************************************************************************************************************************
	 * Method: viewnewmovies
     *Description: To give a list of new movies in database. 
	 * @throws MovieNotFoundException 
	 * @returns List<Movie>       - all movies which are recently added and currently active.
                *Created By                              - 
                *Created Date                            - 26-SEP-2020                           	 
	 **********************************************************************************************************************************/	
	@GetMapping("/viewnewmovies")
	public List<Movie> viewNewMovies() throws MovieNotFoundException {
		return service.viewNewMovies();
	}
	

	@PostMapping("/AddMovie")
	public String addMovie(@RequestBody Movie movieobject)  {
		
        dao.addMovie(movieobject);
        
		return "Movie Added";
	}
		 

}
