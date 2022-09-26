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

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.dto.PlacesDTO;
import com.casestudy.entities.Places;
import com.casestudy.repositories.PlacesRepository;
import com.casestudy.services.PlaceService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class MainController {

	@Autowired
	RestTemplate restTemplate;

	
	@Autowired
	PlaceService placeService;
	
    @GetMapping(value = "/nearbyPlaces")
    public ResponseEntity<?> getNearbyPlaces(@Valid @RequestBody Places place) {
    
	
    		if(!isPlaceExistInDB(place)) 
    		{
    			
    			String response=getGoogleAPIresponse(place.getLongtitude(),place.getLatitude(),place.getRadius());
    			place.setResponse(response);  		
    			savePlace(place);    		
    			log.info("A place with Latitude value"+place.getLatitude()+" and Longtitude value" + place.getLongtitude()+ " saved to database");
    			return ResponseEntity.status(HttpStatus.OK).body(response);
    		  
    		}    		    		
    	     	
    		else	
    		{	
    			
    			Places findPlace=placeService.findByLatitudeAndLongtitudeAndRadius(place.getLatitude(), place.getLongtitude(), place.getRadius());
    			
    			if(findPlace!=null) 
    			{
    				
    				 return ResponseEntity.status(HttpStatus.OK).body(findPlace.getResponse());
    				
    			}
    			
    			else 
    			{
    				log.error("A place with Latitude value"+place.getLatitude()+" and Longtitude value" + place.getLongtitude()+ " is not found in database");
    				 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unexpected Error");
    				
    			}
    			  			
    		    
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
   
    public String getGoogleAPIresponse(Double longtitude,Double latitude,Short radius) {
	  
    	String response=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",String.class);
    	
    	 return response;
    	
    }
    
    
   
  

}
