package com.casestudy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.dto.PlacesDTO;
import com.casestudy.entities.Places;
import com.casestudy.repositories.PlacesRepository;
import com.casestudy.services.PlaceService;


@RestController

public class MainController {

	@Autowired
	RestTemplate restTemplate;

	
	@Autowired
	PlaceService placeService;
	
    @GetMapping(value = "/nearbyPlaces")
    public ResponseEntity<?> getNearbyPlaces(@Valid @RequestBody Places place) {
    
	
    		if(!isPlaceExistInDB(place)) 
    		{
    			
    		  savePlace(place);
    		  return getGoogleAPIresponse(place.getLongtitude(),place.getLatitude(),place.getRadius());
    		  
    		}    		    		
    	     	
    		else	
    		{	
    			
    			Places findPlace=placeService.findByLatitudeAndLongtitudeAndRadius(place.getLatitude(), place.getLongtitude(), place.getRadius());
    			
    			if(findPlace!=null) 
    			{
    				
    				 return ResponseEntity.status(HttpStatus.OK).body(findPlace.getResponse());
    				
    			}
    			return getGoogleAPIresponse(place.getLongtitude(),place.getLatitude(),place.getRadius());   			
    		    
    		}

    }
    
    
    //Check is place exist in database
    public boolean isPlaceExistInDB(Places place) {
    	
    	return placeService.isPlaceExistInDB(place);
    }
  
    //Save place to database
    public void savePlace(Places place) {
    	
    	placeService.savePlace(place);
    }
    
    
    //Get response from Google Places API
   
    public ResponseEntity<?> getGoogleAPIresponse(Double longtitude,Double latitude,Short radius) {
	  
    	
    	 return ResponseEntity.status(HttpStatus.OK).body("Test");
    	
    }
    
    
   
  

}
