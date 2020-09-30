package com.cg.moviemanagement.service;

import java.util.List;

import com.cg.moviemanagement.dto.Screen;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.ShowException;

/************************************************************************************
 *          @author          Shubham
 *          Description      It is a Show service interface that provides the services for viewing the shows  
                             and the screens of their respective movies.                            
 *          Version          2.0
 *          Created Date     23-SEPT-2020
************************************************************************************/

public interface ShowService {
	public List<Show> getShows(int movieId) throws ShowException ;
	public List<Screen> getScreens(int movieId)throws ShowException;
}