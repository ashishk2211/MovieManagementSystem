package com.cg.moviemanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.exceptions.ShowException;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;

@RestControllerAdvice
public class ExceptionController {
	
	@CrossOrigin
	@ExceptionHandler(value= {MovieNotFoundException.class, BookingException.class,ShowException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public Map<String,String> handleException(Exception ex) {
	
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}

}
