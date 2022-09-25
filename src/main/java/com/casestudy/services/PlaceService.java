package com.casestudy.services;

import org.springframework.stereotype.Service;

import com.casestudy.dto.PlacesDTO;
import com.casestudy.entities.Places;


public interface PlaceService {
	
	void savePlace(Places place);

	boolean isPlaceExistInDB(Places place);
	
	Places findByLatitudeAndLongtitudeAndRadius(Double latitude,Double longtitude,Short radius);
	
	

}
