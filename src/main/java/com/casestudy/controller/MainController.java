package com.casestudy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
	
    @GetMapping(value = "/nearbyPlaces")
    public void getNearbyPlaces(@Valid @RequestBody Places place,BindingResult result) {
    	if(!result.hasErrors() && !isPlaceExistInDB(place)) 
    	{
    		
    		savePlace(place);
    		
    	}
    	
       
        
    }
    
    
    public boolean isPlaceExistInDB(Places place) {
    	
    	return placeService.isPlaceExistInDB(place);
    }
  
    
    public void savePlace(Places place) {
    	
    	
    	placeService.savePlace(place);
    }
    
    
    
    

  

}
