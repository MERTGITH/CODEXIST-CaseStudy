package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.entities.Places;
import com.casestudy.repositories.PlacesRepository;


@RestController
public class MainController {
	
	@Autowired
	PlacesRepository placesRepo;
	
   /* @RequestMapping(value = "/nearbyPlaces", method = RequestMethod.POST)
    public Places getNearbyPlaces(@RequestBody Places place) {
        Places savedPlace=placesRepo.save(place);
      
        return savedPlace;
    }
    */
    

  

}
