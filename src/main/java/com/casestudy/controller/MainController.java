package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.PlacesDTO;
import com.casestudy.entities.Places;
import com.casestudy.repositories.PlacesRepository;
import com.casestudy.services.PlaceService;


@RestController
public class MainController {
	
	
	
	@Autowired
	PlaceService placeService;
	
    @RequestMapping(value = "/nearbyPlaces", method = RequestMethod.POST)
    public Places getNearbyPlaces(@RequestBody Places place) {
    	
    	 if(!isPlaceExistInDB(place)) 
    	 {
    		 
    	  Places savedPlace=savePlace(place);
    	  
    	 }
       
        return savedPlace;
    }
    
    
    public boolean isPlaceExistInDB(Places place) {
    	
    	return placeService.isPlaceExistInDB(place);
    }
  
    
    public Places savePlace(Places place) {
    	
    	
    	return placeService.savePlace(place);
    }
    
    
    
    

  

}
